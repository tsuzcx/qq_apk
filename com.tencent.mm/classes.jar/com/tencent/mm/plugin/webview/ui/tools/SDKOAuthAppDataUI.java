package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Options;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.eux;
import com.tencent.mm.protocal.protobuf.fan;
import com.tencent.mm.protocal.protobuf.fuw;
import com.tencent.mm.protocal.protobuf.fux;
import com.tencent.mm.protocal.protobuf.fuy;
import com.tencent.mm.protocal.protobuf.fuz;
import com.tencent.mm.protocal.protobuf.fva;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.j;
import java.io.IOException;
import java.util.LinkedList;

public class SDKOAuthAppDataUI
  extends MMActivity
  implements q, com.tencent.mm.am.h
{
  private int VaW = 2;
  private aj WTf;
  private eux WTg;
  private a WTh;
  private g WTi;
  private LinkedList<fuw> WTj;
  private com.tencent.mm.bx.b WTk;
  private fuy WTl;
  public LinkedList<String> WTm;
  private String appId;
  private String extData;
  private w lKp;
  private SendAuth.Options options;
  private int rFX;
  private long startTime;
  private String state;
  private String transaction;
  
  private void ddd()
  {
    AppMethodBeat.i(296414);
    if (this.lKp == null)
    {
      AppMethodBeat.o(296414);
      return;
    }
    this.lKp.dismiss();
    AppMethodBeat.o(296414);
  }
  
  private void ixr()
  {
    AppMethodBeat.i(296416);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)findViewById(c.f.auth_content_desc);
    localMMNeat7extView.aZ(com.tencent.mm.pluginsdk.ui.span.p.j(getContext(), this.WTl.abSQ.content, (int)localMMNeat7extView.getTextSize()));
    localMMNeat7extView.setOnTouchListener(new l(localMMNeat7extView, new com.tencent.mm.pluginsdk.ui.span.s(localMMNeat7extView.getContext())));
    AppMethodBeat.o(296416);
  }
  
  public int getLayoutId()
  {
    return c.g.sdkoauth_appdata_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(296446);
    Log.i("MicroMsg.SDKOAuthAppDataUI", "onCreate");
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(1346, this);
    com.tencent.mm.kernel.h.aZW().a(1137, this);
    paramBundle = getIntent();
    this.WTm = new LinkedList(paramBundle.getStringArrayListExtra("has_selected_scope"));
    this.appId = paramBundle.getStringExtra("0");
    this.transaction = paramBundle.getStringExtra("1");
    try
    {
      this.WTg = ((eux)new eux().parseFrom(paramBundle.getByteArrayExtra("2")));
      this.state = paramBundle.getStringExtra("4");
      this.extData = paramBundle.getStringExtra("7");
      this.WTf = new aj(this, this.appId, this.transaction, this.state, this.extData);
      this.rFX = paramBundle.getIntExtra("3", -1);
      paramBundle = paramBundle.getBundleExtra("send_auth_option");
      if (paramBundle != null)
      {
        this.options = new SendAuth.Options();
        this.options.fromBundle(paramBundle);
        Log.i("MicroMsg.SDKOAuthAppDataUI", "options.callbackClassName: " + this.options.callbackClassName + "  options.callbackFlags: " + this.options.callbackFlags);
        paramBundle = this.WTg.abxB;
        if ((paramBundle != null) && (paramBundle.Op.length > 0)) {
          localObject = new cut();
        }
      }
    }
    catch (IOException localIOException)
    {
      try
      {
        for (;;)
        {
          ((cut)localObject).parseFrom(paramBundle.toByteArray());
          this.WTj = ((cut)localObject).aaAk;
          this.WTk = ((cut)localObject).aaAl;
          this.WTl = ((cut)localObject).aaAm;
          paramBundle = getSupportActionBar();
          if (paramBundle != null) {
            paramBundle.hide();
          }
          ((TextView)findViewById(c.f.leftClose)).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(296378);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthAppDataUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthAppDataUI.a(SDKOAuthAppDataUI.this), SDKOAuthAppDataUI.b(SDKOAuthAppDataUI.this), 0, SDKOAuthAppDataUI.c(SDKOAuthAppDataUI.this), 5, 1, 0);
              SDKOAuthAppDataUI.e(SDKOAuthAppDataUI.this).a(-2, SDKOAuthAppDataUI.d(SDKOAuthAppDataUI.this));
              SDKOAuthAppDataUI.this.finish();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthAppDataUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(296378);
            }
          });
          paramBundle = (ImageView)findViewById(c.f.new_app_icon_iv_appdatapage);
          Object localObject = (TextView)findViewById(c.f.new_app_name_tv_appdatapage);
          ((TextView)localObject).getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
          ((TextView)localObject).getPaint().setStrokeWidth(0.8F);
          c.a locala = new c.a();
          locala.oKB = c.h.native_oauth_default_head_img;
          locala.oKI = getResources().getDimension(c.d.sdk_oauth_header_corners_size);
          locala.nrc = true;
          locala.oKp = true;
          locala.prefixPath = com.tencent.mm.plugin.openapi.a.gxk();
          r.bKe().a(this.WTl.abSO.icon_url, paramBundle, locala.bKx());
          ((TextView)localObject).setText(this.WTl.abSO.ZWh);
          ((TextView)findViewById(c.f.new_app_name_tv_appdatapage_action)).setText(this.WTl.abSO.title);
          paramBundle = (TextView)findViewById(c.f.auth_content_appdatapage);
          paramBundle.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
          paramBundle.getPaint().setStrokeWidth(0.8F);
          paramBundle.setText(this.WTl.abSO.wsz);
          this.WTh = new a(getContext(), this.WTl.abSP.ZgM);
          paramBundle = (RecyclerView)findViewById(c.f.auth_content_recycle);
          paramBundle.setAdapter(this.WTh);
          localObject = new LinearLayoutManager();
          ((LinearLayoutManager)localObject).setOrientation(1);
          paramBundle.setLayoutManager((RecyclerView.LayoutManager)localObject);
          ixr();
          paramBundle = (Button)findViewById(c.f.login_btn_agree_appdatapage);
          localObject = (Button)findViewById(c.f.login_btn_disagree_appdatapage);
          this.startTime = System.currentTimeMillis();
          paramBundle.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(296376);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthAppDataUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthAppDataUI.a(SDKOAuthAppDataUI.this), SDKOAuthAppDataUI.b(SDKOAuthAppDataUI.this), 1, SDKOAuthAppDataUI.c(SDKOAuthAppDataUI.this), 5, 1, 0);
              SDKOAuthAppDataUI.a(SDKOAuthAppDataUI.this, true);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthAppDataUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(296376);
            }
          });
          ((Button)localObject).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(296367);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthAppDataUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthAppDataUI.a(SDKOAuthAppDataUI.this), SDKOAuthAppDataUI.b(SDKOAuthAppDataUI.this), 0, SDKOAuthAppDataUI.c(SDKOAuthAppDataUI.this), 5, 1, 0);
              SDKOAuthAppDataUI.a(SDKOAuthAppDataUI.this, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthAppDataUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(296367);
            }
          });
          AppMethodBeat.o(296446);
          return;
          localIOException = localIOException;
          Log.e("MicroMsg.SDKOAuthAppDataUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        }
        Log.i("MicroMsg.SDKOAuthAppDataUI", "SendAuth.options, bundle is null");
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDKOAuthAppDataUI", "GetUserGrantInfoBuffer parseFrom byteArray failed");
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(296453);
    super.onDestroy();
    ddd();
    com.tencent.mm.kernel.h.aZW().b(1346, this);
    com.tencent.mm.kernel.h.aZW().b(1137, this);
    Log.i("MicroMsg.SDKOAuthAppDataUI", "onDestroy");
    AppMethodBeat.o(296453);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(296456);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.k.b.XsD.a(this.appId, this.startTime, 0, this.VaW, 5, 1, 0);
      this.WTf.a(-2, this.options);
      finish();
      AppMethodBeat.o(296456);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(296456);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(296451);
    super.onPause();
    Log.i("MicroMsg.SDKOAuthAppDataUI", "onPause");
    AppMethodBeat.o(296451);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(296449);
    super.onResume();
    Log.i("MicroMsg.SDKOAuthAppDataUI", "onResume");
    AppMethodBeat.o(296449);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(296466);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.k.b.XsD.a(this.appId, this.startTime, 2, this.VaW, 5, 1, paramInt2);
    }
    ddd();
    if ((paramp instanceof ac)) {
      this.WTf.a(paramInt1, paramInt2, paramString, paramp, this.options);
    }
    AppMethodBeat.o(296466);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends RecyclerView.a<SDKOAuthAppDataUI.b>
  {
    private LinkedList<dcn> WTq;
    private LinkedList<dcn> WTr;
    public fan WTs;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(LinkedList<dcn> paramLinkedList)
    {
      AppMethodBeat.i(296242);
      this.mInflater = LayoutInflater.from(paramLinkedList);
      this.WTq = ((LinkedList)localObject);
      this.WTr = this.WTq;
      this.mContext = paramLinkedList;
      this.WTs = new fan();
      this.WTs.aaAl = SDKOAuthAppDataUI.h(SDKOAuthAppDataUI.this);
      this.WTs.aaAk = SDKOAuthAppDataUI.i(SDKOAuthAppDataUI.this);
      SDKOAuthAppDataUI.a(SDKOAuthAppDataUI.this, new g(this.mContext, SDKOAuthAppDataUI.j(SDKOAuthAppDataUI.this).abSP.ZgM, SDKOAuthAppDataUI.i(SDKOAuthAppDataUI.this)));
      paramLinkedList = View.inflate(this.mContext, c.g.sdk_auth_appdata_halfbottom_header, null);
      Object localObject = (TextView)paramLinkedList.findViewById(c.f.sdk_auth_appdata_halfbottom_header_title);
      ((TextView)localObject).getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
      ((TextView)localObject).getPaint().setStrokeWidth(0.8F);
      localObject = SDKOAuthAppDataUI.k(SDKOAuthAppDataUI.this);
      ((g)localObject).xcO.mi(paramLinkedList);
      ((g)localObject).tss = paramLinkedList;
      SDKOAuthAppDataUI.k(SDKOAuthAppDataUI.this).WSX.a((MMActivity)this.mContext, new y() {});
      AppMethodBeat.o(296242);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(296258);
      int i = this.WTr.size();
      AppMethodBeat.o(296258);
      return i;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public TextView WTv;
    public TextView WTw;
    public TextView WTx;
    public View caK;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(296238);
      this.caK = paramView;
      this.WTv = ((TextView)paramView.findViewById(c.f.scope_item_appdata_auth_name));
      this.WTw = ((TextView)paramView.findViewById(c.f.scope_item_appdata_auth_selection));
      this.WTx = ((TextView)paramView.findViewById(c.f.scope_item_appdata_auth_desc));
      AppMethodBeat.o(296238);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthAppDataUI
 * JD-Core Version:    0.7.0.1
 */