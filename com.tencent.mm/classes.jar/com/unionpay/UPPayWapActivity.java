package com.unionpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.unionpay.utils.k;
import org.json.JSONException;
import org.json.JSONObject;

public class UPPayWapActivity
  extends HellActivity
{
  private WebView aisB;
  private b aisC;
  private AlertDialog aisD;
  LinearLayout aisE;
  private boolean e = false;
  
  private void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207245);
    Intent localIntent = new Intent();
    localIntent.putExtra("pay_result", paramString1);
    localIntent.putExtra("result_data", paramString2);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(207245);
  }
  
  private static String bT(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(207239);
    try
    {
      JSONObject localJSONObject = new JSONObject("{\"code\":\"0\",\"msg\":\"success\"}");
      if (paramString1 != null) {
        localJSONObject.put("code", paramString1);
      }
      if (paramString2 != null) {
        localJSONObject.put("msg", paramString2);
      }
      if (paramString3 != null) {
        localJSONObject.put("value", paramString3);
      }
      paramString1 = localJSONObject.toString();
      AppMethodBeat.o(207239);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      AppMethodBeat.o(207239);
    }
    return "";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(207303);
    super.onCreate(paramBundle);
    getWindow().addFlags(8192);
    try
    {
      if (!"949A1CC".equalsIgnoreCase(getIntent().getStringExtra("magic_data"))) {
        finish();
      }
      this.e = "link".equals(getIntent().getStringExtra("actionType"));
      paramBundle = "";
      getWindow().requestFeature(1);
      localLinearLayout = new LinearLayout(this);
      localLinearLayout.setOrientation(1);
      setContentView(localLinearLayout);
      this.aisB = new WebView(this);
      if (this.e) {
        break label812;
      }
      str = getIntent().getStringExtra("waptype");
      if ((str == null) || (!str.equals("new_page"))) {
        break label736;
      }
      localObject1 = getIntent().getStringExtra("wapurl");
      str = getIntent().getStringExtra("waptitle");
      if (localObject1 == null) {
        break label850;
      }
      paramBundle = (Bundle)localObject1;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        String str;
        try
        {
          LinearLayout localLinearLayout;
          Object localObject1;
          Object localObject2;
          RelativeLayout localRelativeLayout;
          int j;
          int i;
          int k;
          int m;
          finish();
          AppMethodBeat.o(207303);
          return;
        }
        catch (Exception paramBundle)
        {
          AppMethodBeat.o(207303);
          return;
        }
        do
        {
          str = "";
          break;
        } while (str == null);
      }
    }
    localObject1 = new f(this);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    localRelativeLayout = new RelativeLayout(this);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    j = com.unionpay.utils.f.a(this, 10.0F);
    i = com.unionpay.utils.f.a(this, 52.0F);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
    localRelativeLayout.setBackgroundColor(-10705958);
    this.aisE = new LinearLayout(this);
    this.aisE.setPadding(j, j, j, j);
    this.aisE.setGravity(16);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = j;
    this.aisE.setOnClickListener((View.OnClickListener)localObject1);
    localRelativeLayout.addView(this.aisE, (ViewGroup.LayoutParams)localObject2);
    j = com.unionpay.utils.f.a(this, 20.0F);
    k = com.unionpay.utils.f.a(this, 11.0F);
    localObject1 = new ImageView(this);
    m = com.unionpay.utils.h.a;
    ((ImageView)localObject1).setBackgroundDrawable(com.unionpay.utils.g.bIv("89504e470d0a1a0a0000000d49484452000000210000003c0806000000e8acd32a000000097048597300000b1300000b1301009a9c1800000a4d6943435050686f746f73686f70204943432070726f66696c65000078da9d53775893f7163edff7650f5642d8f0b1976c81002223ac08c81059a21092006184101240c585880a561415119c4855c482d50a489d88e2a028b867418a885a8b555c38ee1fdca7b57d7aefededfbd7fbbce79ce7fcce79cf0f8011122691e6a26a003952853c3ad81f8f4f48c4c9bd80021548e0042010e6cbc26705c50000f00379787e74b03ffc01af6f00020070d52e2412c7e1ff83ba50265700209100e02212e70b01905200c82e54c81400c81800b053b3640a009400006c797c422200aa0d00ecf4493e0500d8a993dc1700d8a21ca908008d0100992847240240bb00605581522c02c0c200a0ac40222e04c0ae018059b632470280bd0500768e58900f4060008099422ccc0020380200431e13cd03204c03a030d2bfe0a95f7085b8480100c0cb95cd974bd23314b895d01a77f2f0e0e221e2c26cb142611729106609e4229c979b231348e7034cce0c00001af9d1c1fe383f90e7e6e4e1e666e76ceff4c5a2fe6bf06f223e21f1dffebc8c020400104ecfefda5fe5e5d60370c701b075bf6ba95b00da560068dff95d33db09a05a0ad07af98b7938fc401e9ea150c83c1d1c0a0b0bed2562a1bd30e38b3eff33e16fe08b7ef6fc401efedb7af000719a4099adc0a383fd71616e76ae528ee7cb0442316ef7e723fec7857ffd8e29d1e234b15c2c158af15889b850224dc779b952914421c995e212e97f32f11f96fd0993770d00ac864fc04eb607b5cb6cc07eee01028b0e58d27600407ef32d8c1a0b91001067343279f7000093bff98f402b0100cd97a4e30000bce8185ca894174cc608000044a0812ab041070cc114acc00e9cc11dbcc01702610644400c24c03c104206e4801c0aa11896411954c03ad804b5b0031aa0119ae110b4c131380de7e0125c81eb70170660189ec218bc86090441c8081361213a8811628ed822ce0817998e04226148349280a420e988145122c5c872a402a9426a915d4823f22d7214398d5c40fa90dbc820328afc8abc47319481b25103d4027540b9a81f1a8ac6a073d174340f5d8096a26bd11ab41e3d80b6a2a7d14be87574007d8a8e6380d1310e668cd9615c8c87456089581a26c71663e55835568f35631d583776151bc09e61ef0824028b8013ec085e8410c26c82909047584c5843a825ec23b412ba085709838431c2272293a84fb4257a12f9c478623ab1905846ac26ee211e219e255e270e135f9348240ec992e44e0a21259032490b496b48db482da453a43ed210699c4c26eb906dc9dee408b280ac209791b7900f904f92fbc9c3e4b7143ac588e24c09a22452a494124a35653fe504a59f324299a0aa51cda99ed408aa883a9f5a496da076502f5387a91334759a25cd9b1643cba42da3d5d09a696769f7682fe974ba09dd831e4597d097d26be807e9e7e983f4770c0d860d83c7486228196b197b19a718b7192f994ca605d39799c85430d7321b9967980f986f55582af62a7c1591ca12953a9556957e95e7aa545573553fd579aa0b54ab550fab5e567da64655b350e3a909d416abd5a91d55bba936aece5277528f50cf515fa3be5ffd82fa630db2868546a08648a35463b7c6198d2116c63265f15842d6725603eb2c6b984d625bb2f9ec4c7605fb1b762f7b4c534373aa66ac6691669de671cd010ec6b1e0f039d99c4ace21ce0dce7b2d032d3f2db1d66aad66ad7ead37da7adabeda62ed72ed16edebdaef75709d409d2c9df53a6d3af77509ba36ba51ba85badb75cfea3ed363eb79e909f5caf50ee9ddd147f56df4a3f517eaefd6efd11f373034083690196c313863f0cc9063e86b9869b8d1f084e1a811cb68ba91c468a3d149a327b826ee8767e33578173e66ac6f1c62ac34de65dc6b3c61626932dba4c4a4c5e4be29cd946b9a66bad1b4d374ccccc82cdcacd8acc9ec8e39d59c6b9e61bed9bcdbfc8d85a5459cc54a8b368bc796da967ccb05964d96f7ac98563e567956f556d7ac49d65ceb2ceb6dd6576c501b579b0c9b3a9bcbb6a8ad9badc4769b6ddf14e2148f29d229f5536eda31ecfcec0aec9aec06ed39f661f625f66df6cf1dcc1c121dd63b743b7c727475cc766c70bceba4e134c3a9c4a9c3e957671b67a1739df33517a64b90cb1297769717536da78aa76e9f7acb95e51aeebad2b5d3f5a39bbb9bdcadd96dd4ddcc3dc57dabfb4d2e9b1bc95dc33def41f4f0f758e271cce39da79ba7c2f390e72f5e765e595efbbd1e4fb39c269ed6306dc8dbc45be0bdcb7b603a3e3d65facee9033ec63e029f7a9f87bea6be22df3dbe237ed67e997e07fc9efb3bfacbfd8ff8bfe179f216f14e056001c101e501bd811a81b3036b031f049904a50735058d05bb062f0c3e15420c090d591f72936fc017f21bf96333dc672c9ad115ca089d155a1bfa30cc264c1ed6118e86cf08df107e6fa6f94ce9ccb60888e0476c88b81f69199917f97d14292a32aa2eea51b453747174f72cd6ace459fb67bd8ef18fa98cb93bdb6ab6727667ac6a6c526c63ec9bb880b8aab8817887f845f1971274132409ed89e4c4d8c43d89e37302e76c9a339ce49a54967463aee5dca2b917e6e9cecb9e773c593559907c3885981297b23fe5832042502f184fe5a76e4d1d13f2849b854f45bea28da251b1b7b84a3c92e69d5695f638dd3b7d43fa68864f4675c633094f522b79911992b923f34d5644d6deaccfd971d92d39949c949ca3520d6996b42bd730b728b74f662b2b930de479e66dca1b9387caf7e423f973f3db156c854cd1a3b452ae500e164c2fa82b785b185b78b848bd485ad433df66feeaf9230b82167cbd90b050b8b0b3d8b87859f1e022bf45bb16238b5317772e315d52ba647869f0d27dcb68cbb296fd50e2585255f26a79dcf28e5283d2a5a5432b82573495a994c9cb6eaef45ab9631561956455ef6a97d55b567f2a17955fac70aca8aef8b046b8e6e2574e5fd57cf5796ddadade4ab7caedeb48eba4eb6eacf759bfaf4abd6a41d5d086f00dad1bf18de51b5f6d4ade74a17a6af58ecdb4cdcacd03356135ed5bccb6acdbf2a136a3f67a9d7f5dcb56fdadabb7bed926dad6bfdd777bf30e831d153bdeef94ecbcb52b78576bbd457df56ed2ee82dd8f1a621bbabfe67eddb847774fc59e8f7ba57b07f645efeb6a746f6cdcafbfbfb2096d52368d1e483a70e59b806fda9bed9a77b5705a2a0ec241e5c127dfa67c7be350e8a1cec3dcc3cddf997fb7f508eb48792bd23abf75ac2da36da03da1bdefe88ca39d1d5e1d47beb7ff7eef31e36375c7358f579ea09d283df1f9e48293e3a764a79e9d4e3f3dd499dc79f74cfc996b5d515dbd6743cf9e3f1774ee4cb75ff7c9f3dee78f5df0bc70f422f762db25b74bad3dae3d477e70fde148af5b6feb65f7cbed573cae74f44deb3bd1efd37ffa6ac0d573d7f8d72e5d9f79bdefc6ec1bb76e26dd1cb825baf5f876f6ed17770aee4cdc5d7a8f78affcbedafdea07fa0fea7fb4feb165c06de0f860c060cfc3590fef0e09879efe94ffd387e1d247cc47d52346238d8f9d1f1f1b0d1abdf264ce93e1a7b2a713cfca7e56ff79eb73abe7dffde2fb4bcf58fcd8f00bf98bcfbfae79a9f372efaba9af3ac723c71fbcce793df1a6fcadcedb7defb8efbadfc7bd1f9928fc40fe50f3d1fa63c7a7d04ff73ee77cfefc2ff784f3fb25d29f33000000206348524d00007a25000080830000f9ff000080e9000075300000ea6000003a980000176f925fc546000002744944415478dabcd9c96b145110c7f1d734b6c9b8ef8a0b2e410cfe77826741100441c48324a006040f8a08828a8a102689c11d238a3b8a0b060feaf7e8e979e9816178f57a7b5587390df47c86ee7e55f52b0738c3cf3ae01af00f580226bdf7ce1af010f0439fbe25622db03802f0c02f2bc41a602100f0c094056215302f00ee0063da881ed01700f78071c069227ac0ac00b85f7eef3411bdf2874280d9618016621cb82b00faa3000dc4caf2610b01e6cb87d469220ae0b60058285f53a78928809b0260b13c299d26a2006e0880475580148802b82e009ed4017445ac28ab6108f014585ff75a6d11397055003c073636b95e1b440e5c11002f804d4dff5453440e5c16004bc09636b7b60922072e0980576d014d10393023005e035bbbbce6751019704100bc01b6753decaa1019705e00bc0576a438f263880c981200ef819da90a9f84c8807302e003b02b65f90f2132e0ac00f804ec4edd0485106704c067608f462b388a382d00be007bb51ae261c42901f015d8a739160c104705c037e080f6703440fc0900be03131623e200f137342302872d114784dbb10c4c5a211c704c80fc040e59211c705c80fc000e5a211c704280a83da852ed3869f9cac6aa68ecf0da6f85303bc6eb7456ea05ad6e7ba75adaeb36bab126e763d726a749cb9f01d31aed5ed3e127d6f8be6bdbf8b6190333e0626404d86e81483e0c758906928d855d4392d880fcb22e24455c5415156cb640740e4d524688b1f8e819b0c102d13a48d388956391e2e310442b602f805b75c355cd55432c667e50aea3d4110e18ab08dc575b20aa560f7340cf6a11175bc24c5bae24a575d4b2f57236b4989bb3460c569433c0ef1234e1bd77ff070038285c304da61b3c0000000049454e44ae426082"));
    localObject2 = new RelativeLayout.LayoutParams(k, j);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    this.aisE.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new RelativeLayout.LayoutParams(com.unionpay.utils.f.a(this, 320.0F), i);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
    localObject2 = new TextView(this);
    ((TextView)localObject2).setTextSize(20.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setText(str);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setSingleLine(true);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localLinearLayout.addView(localRelativeLayout);
    for (;;)
    {
      this.aisB.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localLinearLayout.addView(this.aisB);
      this.aisC = new b(this, this.aisB);
      this.aisC.aisJ = this.e;
      if (this.aisB != null) {
        this.aisB.loadUrl(paramBundle);
      }
      if (this.aisC != null)
      {
        this.aisC.a("getDeviceInfo", new l(this));
        this.aisC.a("saveData", new m(this));
        this.aisC.a("getData", new n(this));
        this.aisC.a("removeData", new o(this));
        this.aisC.a("setPageBackEnable", new p(this));
        this.aisC.a("payBySDK", new q(this));
        this.aisC.a("payResult", new r(this));
        this.aisC.a("closePage", new g(this));
        this.aisC.a("openNewPage", new h(this));
      }
      AppMethodBeat.o(207303);
      return;
      label736:
      str = getIntent().getStringExtra("wapurl");
      localObject1 = getIntent().getStringExtra("paydata");
      if (localObject1 != null) {
        paramBundle = str + "?s=" + (String)localObject1;
      }
      str = k.kkC().e;
      localObject1 = new i(this);
      break;
      label812:
      paramBundle = getIntent().getStringExtra("wapurl");
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(207313);
    if (paramInt == 4)
    {
      if (this.e)
      {
        if ((this.aisB != null) && (this.aisB.canGoBack()))
        {
          this.aisB.goBack();
          AppMethodBeat.o(207313);
          return true;
        }
        a("cancel", null);
      }
      for (;;)
      {
        AppMethodBeat.o(207313);
        return true;
        onPause();
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(207313);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.UPPayWapActivity
 * JD-Core Version:    0.7.0.1
 */