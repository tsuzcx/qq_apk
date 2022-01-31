package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.h.b.a.u;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.bsz;
import com.tencent.mm.protocal.c.bue;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.c.d.i;

public final class ag
  extends a
{
  private String appId;
  private String appName;
  MMActivity bER;
  private String fKV;
  private int oOs;
  private com.tencent.mm.modelsns.b oOy = null;
  private boolean oPR = false;
  private boolean oPS = false;
  private WXMediaMessage oPT = null;
  private String oQO;
  private boolean oQP = false;
  ag.b oSd = new ag.b(this);
  v oSe;
  Map<String, Exif.a> oSf = new HashMap();
  private Map<String, bue> oSg = new HashMap();
  private int oSh = 0;
  private boolean oSi = false;
  aui oSj;
  
  public ag(MMActivity paramMMActivity)
  {
    this.bER = paramMMActivity;
  }
  
  private boolean G(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return false;
      paramBundle = paramBundle.getStringArrayList("sns_media_latlong_list");
    } while (paramBundle == null);
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      String[] arrayOfString = ((String)paramBundle.next()).split("\n");
      if (3 != arrayOfString.length)
      {
        y.e("MicroMsg.PicWidget", "invalid params");
        return true;
      }
      try
      {
        this.oSf.put(arrayOfString[0].trim(), new Exif.a(bk.getDouble(arrayOfString[1], 0.0D), bk.getDouble(arrayOfString[2], 0.0D), 0.0D));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        y.e("MicroMsg.PicWidget", localNumberFormatException.toString());
      }
    }
    return true;
  }
  
  private static ax a(ax paramax, List<com.tencent.mm.plugin.sns.data.h> paramList)
  {
    paramax.cy(paramList);
    return paramax;
  }
  
  public final void E(Bundle paramBundle)
  {
    this.oOy = com.tencent.mm.modelsns.b.i(this.bER.getIntent());
    this.oQP = this.bER.getIntent().getBooleanExtra("Kis_take_photo", false);
    this.appId = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.oPR = this.bER.getIntent().getBooleanExtra("KThrid_app", false);
    this.oSi = this.bER.getIntent().getBooleanExtra("KBlockAdd", false);
    this.oPS = this.bER.getIntent().getBooleanExtra("KSnsAction", false);
    this.oOs = this.bER.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.fKV = bk.aM(this.bER.getIntent().getStringExtra("reportSessionId"), "");
    this.oQO = this.bER.getIntent().getStringExtra("KSessionID");
    Object localObject1 = this.bER.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (localObject1 != null) {
      this.oPT = new SendMessageToWX.Req((Bundle)localObject1).message;
    }
    Object localObject3 = this.bER.getIntent().getStringExtra("sns_kemdia_path");
    Object localObject4 = this.bER.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      localObject1 = localObject4;
      if (this.oPT != null)
      {
        localObject1 = localObject4;
        if (this.oPT.mediaObject != null)
        {
          localObject1 = localObject4;
          if ((this.oPT.mediaObject instanceof WXImageObject)) {
            localObject1 = ((WXImageObject)this.oPT.mediaObject).imageData;
          }
        }
      }
    }
    if ((bk.bl((String)localObject3)) && (!bk.bE((byte[])localObject1)))
    {
      localObject3 = af.getAccSnsTmpPath() + com.tencent.mm.a.g.o(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
      com.tencent.mm.vfs.e.deleteFile((String)localObject3);
      com.tencent.mm.vfs.e.b((String)localObject3, (byte[])localObject1, localObject1.length);
    }
    label470:
    label496:
    Object localObject2;
    for (localObject1 = localObject3;; localObject2 = localObject3)
    {
      int j = this.bER.getIntent().getIntExtra("KFilterId", 0);
      boolean bool;
      if (paramBundle == null)
      {
        localObject3 = null;
        G(paramBundle);
        bool = G(this.bER.getIntent().getExtras());
        this.oSh = 0;
        if (bk.bl((String)localObject3)) {
          break label470;
        }
        this.oSd.Pk((String)localObject3);
      }
      label695:
      do
      {
        return;
        localObject3 = paramBundle.getString("sns_kemdia_path_list");
        break;
        paramBundle = this.bER.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
        if (!bk.dk(paramBundle))
        {
          paramBundle = paramBundle.iterator();
          if (paramBundle.hasNext())
          {
            localObject1 = (String)paramBundle.next();
            y.d("MicroMsg.PicWidget", "newPath " + (String)localObject1);
            this.oSd.o((String)localObject1, j, false);
            if (!bool)
            {
              localObject3 = Exif.fromFile((String)localObject1).getLocation();
              if (localObject3 != null) {
                this.oSf.put(localObject1, localObject3);
              }
            }
          }
          for (;;)
          {
            try
            {
              localObject3 = new com.tencent.mm.vfs.b((String)localObject1);
              localObject4 = new bue();
              if (!this.oQP) {
                break label695;
              }
              i = 1;
              ((bue)localObject4).tKW = i;
              ((bue)localObject4).tKY = (((com.tencent.mm.vfs.b)localObject3).lastModified() / 1000L);
              ((bue)localObject4).tKX = Exif.fromFile((String)localObject1).getUxtimeDatatimeOriginal();
              this.oSg.put(localObject1, localObject4);
            }
            catch (Exception localException)
            {
              y.e("MicroMsg.PicWidget", "get report info error " + localException.getMessage());
            }
            break label496;
            break;
            i = 2;
          }
        }
      } while (bk.bl(localException));
      paramBundle = af.getAccSnsTmpPath() + "pre_temp_sns_pic" + com.tencent.mm.a.g.o(localException.getBytes());
      com.tencent.mm.vfs.e.nb(com.tencent.mm.vfs.e.aeS(paramBundle));
      com.tencent.mm.vfs.e.r(localException, paramBundle);
      if (j == -1) {}
      for (int i = 0;; i = j)
      {
        this.oSd.o(paramBundle, i, this.oQP);
        if (!bool)
        {
          localObject3 = Exif.fromFile(localException).getLocation();
          if (localObject3 != null) {
            this.oSf.put(paramBundle, localObject3);
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = new com.tencent.mm.vfs.b(localException);
            localObject4 = new bue();
            if (this.oQP)
            {
              i = 1;
              ((bue)localObject4).tKW = i;
              ((bue)localObject4).tKY = (((com.tencent.mm.vfs.b)localObject3).lastModified() / 1000L);
              ((bue)localObject4).tKX = Exif.fromFile(localException).getUxtimeDatatimeOriginal();
              this.oSg.put(paramBundle, localObject4);
              return;
            }
          }
          catch (Exception paramBundle)
          {
            y.e("MicroMsg.PicWidget", "get report info error " + paramBundle.getMessage());
            return;
          }
          i = 2;
        }
      }
    }
  }
  
  public final void F(Bundle paramBundle)
  {
    paramBundle.putString("sns_kemdia_path_list", this.oSd.toString());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.oSf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(String.format("%s\n%f\n%f", new Object[] { localEntry.getKey(), Double.valueOf(((Exif.a)localEntry.getValue()).latitude), Double.valueOf(((Exif.a)localEntry.getValue()).longitude) }));
    }
    paramBundle.putStringArrayList("sns_media_latlong_list", localArrayList);
    paramBundle.getString("contentdesc");
  }
  
  public final View a(View paramView1, View paramView2, DynamicGridView paramDynamicGridView, View paramView3)
  {
    boolean bool;
    if (this.oSe == null)
    {
      MMActivity localMMActivity = this.bER;
      ArrayList localArrayList = this.oSd.oSo;
      v.a local1 = new v.a()
      {
        public final void yx(int paramAnonymousInt)
        {
          y.d("MicroMsg.PicWidget", "I click");
          if (paramAnonymousInt < 0)
          {
            ag.this.bHY();
            return;
          }
          Intent localIntent = new Intent();
          localIntent.setClass(ag.this.bER, SnsUploadBrowseUI.class);
          localIntent.putExtra("sns_gallery_position", paramAnonymousInt);
          localIntent.putExtra("sns_gallery_temp_paths", ag.this.oSd.oSo);
          ag.this.bER.startActivityForResult(localIntent, 7);
        }
      };
      ag.2 local2 = new ag.2(this);
      if (!this.oSi)
      {
        bool = true;
        this.oSe = new com.tencent.mm.plugin.sns.ui.previewimageview.e(paramView1, paramView2, paramView3, localMMActivity, localArrayList, paramDynamicGridView, local1, local2, bool);
      }
    }
    for (;;)
    {
      return this.oSe.getView();
      bool = false;
      break;
      this.oSe.setList$22875ea3(this.oSd.oSo);
    }
  }
  
  final void a(ax paramax)
  {
    int i = paramax.commit();
    if (this.oOy != null)
    {
      this.oOy.jf(i);
      f.ozP.c(this.oOy);
    }
    if ((this.oSd != null) && (this.oSd.oSo != null) && (com.tencent.mm.plugin.sns.storage.s.bHd())) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(12834, new Object[] { Integer.valueOf(this.oSd.oSo.size()) });
    }
    paramax = new Intent();
    paramax.putExtra("sns_local_id", i);
    this.bER.setResult(-1, paramax);
    this.bER.finish();
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, aui paramaui, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    paramString2 = new LinkedList();
    Object localObject1 = this.oSd.oSo.iterator();
    int i = 0;
    Object localObject2;
    Object localObject3;
    label103:
    Object localObject4;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new com.tencent.mm.plugin.sns.data.h((String)localObject2, 2);
      ((com.tencent.mm.plugin.sns.data.h)localObject3).type = 2;
      ((com.tencent.mm.plugin.sns.data.h)localObject3).onb = paramInt1;
      int j;
      if (i == 0)
      {
        ((com.tencent.mm.plugin.sns.data.h)localObject3).ona = paramInt2;
        if (parami != null)
        {
          ((com.tencent.mm.plugin.sns.data.h)localObject3).ond = parami.token;
          ((com.tencent.mm.plugin.sns.data.h)localObject3).one = parami.tsv;
        }
        localObject4 = this.oSd;
        if (!((ag.b)localObject4).oSq.containsKey(localObject2)) {
          break label242;
        }
        j = ((Integer)((ag.b)localObject4).oSq.get(localObject2)).intValue();
        label144:
        ((com.tencent.mm.plugin.sns.data.h)localObject3).filterId = j;
        ((com.tencent.mm.plugin.sns.data.h)localObject3).desc = paramString1;
        localObject4 = this.oSd;
        if ((bk.bl((String)localObject2)) || (!((ag.b)localObject4).oSp.containsKey(localObject2))) {
          break label248;
        }
      }
      label242:
      label248:
      for (boolean bool = ((Boolean)((ag.b)localObject4).oSp.get(localObject2)).booleanValue();; bool = false)
      {
        ((com.tencent.mm.plugin.sns.data.h)localObject3).ong = bool;
        paramString2.add(localObject3);
        i += 1;
        break;
        ((com.tencent.mm.plugin.sns.data.h)localObject3).ona = 0;
        break label103;
        j = 0;
        break label144;
      }
    }
    localObject1 = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      localObject2 = com.tencent.mm.model.s.Ha();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject3 = (String)paramList1.next();
        if (!((List)localObject2).contains(localObject3))
        {
          localObject4 = new buw();
          ((buw)localObject4).hPY = ((String)localObject3);
          ((LinkedList)localObject1).add(localObject4);
        }
      }
    }
    paramList1 = new ax(1);
    paramPInt.value = paramList1.avS;
    if (parami != null) {
      paramList1.eM(parami.token, parami.tsv);
    }
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.omJ) {
      paramList1.xS(3);
    }
    paramList1.NR(paramString1).a(paramaui).am((LinkedList)localObject1).xU(paramInt1).xV(paramInt2);
    if (paramBoolean) {
      paramList1.xX(1);
    }
    for (;;)
    {
      if (!bk.bl(this.appId)) {
        paramList1.NX(this.appId);
      }
      if (!bk.bl(this.appName)) {
        paramList1.NY(bk.aM(this.appName, ""));
      }
      paramList1.xW(this.oOs);
      if (this.oPR) {
        paramList1.xW(5);
      }
      if ((this.oPS) && (this.oPT != null))
      {
        paramList1.NS(this.oPT.mediaTagName);
        paramList1.Y(this.appId, this.oPT.messageExt, this.oPT.messageAction);
      }
      paramList1.f(null, null, null, paramInt4, paramInt5);
      paramList1.cx(paramList2);
      paramList1.setSessionId(this.fKV);
      if ((paramaui != null) && (paramaui.score != 0))
      {
        paramInt1 = paramaui.score;
        parami = paramaui.tpQ;
        paramList1.ouz.tsE = new bsz();
        paramList1.ouz.tsE.tJG = paramInt1;
        paramList1.ouz.tsE.tJD = parami;
      }
      y.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", new Object[] { Integer.valueOf(paramString2.size()), Integer.valueOf(this.oSh) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(11602, new Object[] { Integer.valueOf(this.oSh), Integer.valueOf(paramString2.size()) });
      parami = paramString2.iterator();
      while (parami.hasNext())
      {
        paramString1 = (com.tencent.mm.plugin.sns.data.h)parami.next();
        y.i("MicroMsg.PicWidget", "commit path  %s len: %d", new Object[] { paramString1.path, Long.valueOf(com.tencent.mm.vfs.e.aeQ(paramString1.path)) });
      }
      paramList1.xX(0);
    }
    paramString1 = paramString2.iterator();
    if (paramString1.hasNext())
    {
      paramaui = ((com.tencent.mm.plugin.sns.data.h)paramString1.next()).path;
      parami = (bue)this.oSg.get(paramaui);
      if (parami != null) {
        break label1330;
      }
      parami = new bue();
    }
    label937:
    label1330:
    for (;;)
    {
      if ((this.oSj != null) && ((this.oSj.sGK != 0.0F) || (this.oSj.sGJ != 0.0F)))
      {
        parami.tKU = this.oSj.sGK;
        parami.tKV = this.oSj.sGJ;
        parami.oQw = this.oSj.oQw;
        parami.aXH = this.oSj.aXH;
        paramaui = (Exif.a)this.oSf.get(paramaui);
        if ((paramaui == null) || ((paramaui.latitude == 0.0D) && (paramaui.longitude == 0.0D))) {
          break label1243;
        }
        parami.tKS = ((float)paramaui.latitude);
      }
      for (parami.tKT = ((float)paramaui.longitude);; parami.tKT = -1000.0F)
      {
        paramaui = new StringBuffer();
        paramaui.append("||index: " + paramList1.ouz.tsz.size());
        paramaui.append("||item poi lat " + parami.tKU + " " + parami.tKV);
        paramaui.append("||item pic lat " + parami.tKS + " " + parami.tKT);
        paramaui.append("||item exitime:" + parami.tKX + " filetime: " + parami.tKY);
        paramaui.append("||item source: " + parami.tKW);
        y.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + paramaui.toString());
        paramList1.ouz.tsz.add(parami);
        break;
        parami.tKU = -1000.0F;
        parami.tKV = -1000.0F;
        break label937;
        label1243:
        parami.tKS = -1000.0F;
      }
      if (paramString2.size() <= 1)
      {
        a(paramList1, paramString2);
        a(paramList1);
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.DS().O(new ag.4(this));
        return true;
        new ag.a(this, paramList1, paramString2).p(new String[] { "" });
      }
    }
  }
  
  protected final boolean bHY()
  {
    com.tencent.mm.kernel.g.DQ();
    if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.gM(this.bER);
      return false;
    }
    if (this.oSd.oSo.size() >= 9)
    {
      com.tencent.mm.ui.base.h.h(this.bER, i.j.sns_upload_litmit, i.j.app_tip);
      return false;
    }
    try
    {
      az localaz = new az(this.bER);
      localaz.phH = new ag.5(this);
      localaz.phI = new ag.6(this);
      localaz.bJQ();
      label94:
      return true;
    }
    catch (Exception localException)
    {
      break label94;
    }
  }
  
  public final boolean bHq()
  {
    if (this.oSd != null)
    {
      ag.b localb = this.oSd;
      if ((localb.oSo != null) && (localb.oSo.size() > 0)) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final View bHr()
  {
    this.oSe = new PreviewImageView(this.bER);
    if (this.oSi) {
      this.oSe.setIsShowAddImage(false);
    }
    this.oSe.setImageClick(new ag.3(this));
    this.oSe.setList$22875ea3(this.oSd.oSo);
    return this.oSe.getView();
  }
  
  public final boolean bHs()
  {
    if (this.oSe != null) {
      this.oSe.clean();
    }
    this.oSf.clear();
    this.oSg.clear();
    return false;
  }
  
  /* Error */
  public final boolean d(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: tableswitch	default:+55 -> 56, 2:+57->58, 3:+142->143, 4:+1041->1042, 5:+55->56, 6:+55->56, 7:+1395->1396, 8:+55->56, 9:+445->446, 10:+55->56, 11:+854->855
    //   57: ireturn
    //   58: ldc 114
    //   60: ldc_w 907
    //   63: invokestatic 336	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_2
    //   67: ifnonnull +5 -> 72
    //   70: iconst_0
    //   71: ireturn
    //   72: ldc 114
    //   74: ldc_w 909
    //   77: invokestatic 336	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: new 176	android/content/Intent
    //   83: dup
    //   84: invokespecial 512	android/content/Intent:<init>	()V
    //   87: astore_3
    //   88: aload_3
    //   89: ldc_w 911
    //   92: iconst_4
    //   93: invokevirtual 518	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   96: pop
    //   97: aload_3
    //   98: ldc_w 913
    //   101: iconst_1
    //   102: invokevirtual 916	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   105: pop
    //   106: aload_3
    //   107: ldc_w 918
    //   110: iconst_1
    //   111: invokevirtual 916	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   114: pop
    //   115: getstatic 922	com/tencent/mm/plugin/sns/c/a:eUR	Lcom/tencent/mm/pluginsdk/m;
    //   118: aload_0
    //   119: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   122: aload_2
    //   123: aload_3
    //   124: invokestatic 269	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   127: iconst_4
    //   128: new 8	com/tencent/mm/plugin/sns/ui/ag$7
    //   131: dup
    //   132: aload_0
    //   133: invokespecial 923	com/tencent/mm/plugin/sns/ui/ag$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/ag;)V
    //   136: invokeinterface 928 7 0
    //   141: iconst_1
    //   142: ireturn
    //   143: ldc 114
    //   145: ldc_w 930
    //   148: invokestatic 336	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_0
    //   152: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   155: invokevirtual 934	com/tencent/mm/ui/MMActivity:getApplicationContext	()Landroid/content/Context;
    //   158: aload_2
    //   159: invokestatic 269	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   162: invokestatic 939	com/tencent/mm/pluginsdk/ui/tools/l:f	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   165: astore_2
    //   166: aload_2
    //   167: ifnonnull +5 -> 172
    //   170: iconst_1
    //   171: ireturn
    //   172: new 176	android/content/Intent
    //   175: dup
    //   176: invokespecial 512	android/content/Intent:<init>	()V
    //   179: astore_3
    //   180: aload_3
    //   181: ldc_w 911
    //   184: iconst_4
    //   185: invokevirtual 518	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   188: pop
    //   189: aload_3
    //   190: ldc_w 918
    //   193: iconst_1
    //   194: invokevirtual 916	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   197: pop
    //   198: aload_3
    //   199: ldc_w 913
    //   202: iconst_1
    //   203: invokevirtual 916	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   206: pop
    //   207: aload_3
    //   208: ldc_w 941
    //   211: aload_2
    //   212: invokevirtual 944	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   215: pop
    //   216: new 263	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   223: aload_2
    //   224: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   230: invokevirtual 287	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   233: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokevirtual 292	java/lang/String:getBytes	()[B
    //   239: invokestatic 298	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   242: astore 4
    //   244: aload_3
    //   245: ldc_w 946
    //   248: new 263	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   255: invokestatic 269	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   258: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 4
    //   263: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokevirtual 944	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   272: pop
    //   273: aload_2
    //   274: invokestatic 345	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   277: invokevirtual 349	com/tencent/mm/compatible/util/Exif:getLocation	()Lcom/tencent/mm/compatible/util/Exif$a;
    //   280: astore 5
    //   282: aload 5
    //   284: ifnull +70 -> 354
    //   287: aload_0
    //   288: getfield 59	com/tencent/mm/plugin/sns/ui/ag:oSf	Ljava/util/Map;
    //   291: new 263	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   298: invokestatic 269	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   301: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 4
    //   306: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: aload 5
    //   314: invokeinterface 143 3 0
    //   319: pop
    //   320: ldc 114
    //   322: ldc_w 948
    //   325: iconst_2
    //   326: anewarray 409	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload 5
    //   333: getfield 419	com/tencent/mm/compatible/util/Exif$a:latitude	D
    //   336: invokestatic 425	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   339: aastore
    //   340: dup
    //   341: iconst_1
    //   342: aload 5
    //   344: getfield 428	com/tencent/mm/compatible/util/Exif$a:longitude	D
    //   347: invokestatic 425	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   350: aastore
    //   351: invokestatic 950	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   354: new 354	com/tencent/mm/protocal/c/bue
    //   357: dup
    //   358: invokespecial 355	com/tencent/mm/protocal/c/bue:<init>	()V
    //   361: astore 5
    //   363: aload 5
    //   365: iconst_1
    //   366: putfield 358	com/tencent/mm/protocal/c/bue:tKW	I
    //   369: aload 5
    //   371: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   374: putfield 367	com/tencent/mm/protocal/c/bue:tKY	J
    //   377: aload 5
    //   379: aload_2
    //   380: invokestatic 345	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   383: getfield 953	com/tencent/mm/compatible/util/Exif:dateTime	Ljava/lang/String;
    //   386: invokestatic 956	com/tencent/mm/sdk/platformtools/bk:ZS	(Ljava/lang/String;)J
    //   389: putfield 373	com/tencent/mm/protocal/c/bue:tKX	J
    //   392: aload_0
    //   393: getfield 61	com/tencent/mm/plugin/sns/ui/ag:oSg	Ljava/util/Map;
    //   396: new 263	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   403: invokestatic 269	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   406: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload 4
    //   411: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: aload 5
    //   419: invokeinterface 143 3 0
    //   424: pop
    //   425: getstatic 922	com/tencent/mm/plugin/sns/c/a:eUR	Lcom/tencent/mm/pluginsdk/m;
    //   428: aload_0
    //   429: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   432: aload_3
    //   433: iconst_4
    //   434: invokeinterface 959 4 0
    //   439: aload_0
    //   440: iconst_1
    //   441: putfield 54	com/tencent/mm/plugin/sns/ui/ag:oQP	Z
    //   444: iconst_1
    //   445: ireturn
    //   446: aload_2
    //   447: ldc_w 961
    //   450: invokevirtual 327	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   453: astore_3
    //   454: aload_3
    //   455: ifnull +10 -> 465
    //   458: aload_3
    //   459: invokevirtual 502	java/util/ArrayList:size	()I
    //   462: ifgt +16 -> 478
    //   465: aload_2
    //   466: ldc_w 963
    //   469: invokevirtual 186	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   472: invokestatic 257	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   475: ifne +352 -> 827
    //   478: aload_3
    //   479: ifnull +119 -> 598
    //   482: aload_3
    //   483: invokevirtual 502	java/util/ArrayList:size	()I
    //   486: ifle +112 -> 598
    //   489: aload_3
    //   490: iconst_0
    //   491: invokevirtual 966	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   494: checkcast 106	java/lang/String
    //   497: astore_3
    //   498: aload_2
    //   499: ldc_w 968
    //   502: invokevirtual 186	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   505: astore 4
    //   507: aload 4
    //   509: invokestatic 257	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   512: ifne +14 -> 526
    //   515: aload 4
    //   517: astore_2
    //   518: aload 4
    //   520: invokestatic 971	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   523: ifne +177 -> 700
    //   526: new 263	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   533: invokestatic 269	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   536: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload_3
    //   540: invokestatic 974	com/tencent/mm/a/g:bQ	(Ljava/lang/String;)Ljava/lang/String;
    //   543: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: astore_2
    //   550: new 976	android/media/MediaMetadataRetriever
    //   553: dup
    //   554: invokespecial 977	android/media/MediaMetadataRetriever:<init>	()V
    //   557: astore 4
    //   559: aload 4
    //   561: aload_3
    //   562: invokevirtual 980	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   565: aload 4
    //   567: lconst_0
    //   568: invokevirtual 984	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   571: astore 5
    //   573: aload 5
    //   575: ifnonnull +34 -> 609
    //   578: ldc 114
    //   580: ldc_w 986
    //   583: invokestatic 122	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload 4
    //   588: invokevirtual 989	android/media/MediaMetadataRetriever:release	()V
    //   591: goto -535 -> 56
    //   594: astore_2
    //   595: goto -539 -> 56
    //   598: aload_2
    //   599: ldc_w 963
    //   602: invokevirtual 186	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   605: astore_3
    //   606: goto -108 -> 498
    //   609: ldc 114
    //   611: ldc_w 991
    //   614: iconst_2
    //   615: anewarray 409	java/lang/Object
    //   618: dup
    //   619: iconst_0
    //   620: aload 5
    //   622: invokevirtual 996	android/graphics/Bitmap:getWidth	()I
    //   625: invokestatic 507	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   628: aastore
    //   629: dup
    //   630: iconst_1
    //   631: aload 5
    //   633: invokevirtual 999	android/graphics/Bitmap:getHeight	()I
    //   636: invokestatic 507	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   639: aastore
    //   640: invokestatic 719	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   643: aload 5
    //   645: bipush 80
    //   647: getstatic 1005	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   650: aload_2
    //   651: iconst_1
    //   652: invokestatic 1010	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   655: aload_2
    //   656: invokestatic 1014	com/tencent/mm/sdk/platformtools/c:YU	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   659: astore 5
    //   661: ldc 114
    //   663: ldc_w 1016
    //   666: iconst_2
    //   667: anewarray 409	java/lang/Object
    //   670: dup
    //   671: iconst_0
    //   672: aload 5
    //   674: getfield 1021	android/graphics/BitmapFactory$Options:outWidth	I
    //   677: invokestatic 507	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: aastore
    //   681: dup
    //   682: iconst_1
    //   683: aload 5
    //   685: getfield 1024	android/graphics/BitmapFactory$Options:outHeight	I
    //   688: invokestatic 507	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   691: aastore
    //   692: invokestatic 719	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   695: aload 4
    //   697: invokevirtual 989	android/media/MediaMetadataRetriever:release	()V
    //   700: ldc 114
    //   702: ldc_w 1026
    //   705: iconst_4
    //   706: anewarray 409	java/lang/Object
    //   709: dup
    //   710: iconst_0
    //   711: aload_3
    //   712: aastore
    //   713: dup
    //   714: iconst_1
    //   715: aload_2
    //   716: aastore
    //   717: dup
    //   718: iconst_2
    //   719: aload_3
    //   720: invokestatic 728	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   723: invokestatic 733	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   726: aastore
    //   727: dup
    //   728: iconst_3
    //   729: aload_2
    //   730: invokestatic 728	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   733: invokestatic 733	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   736: aastore
    //   737: invokestatic 719	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   740: aload_3
    //   741: invokestatic 974	com/tencent/mm/a/g:bQ	(Ljava/lang/String;)Ljava/lang/String;
    //   744: astore 4
    //   746: aload_0
    //   747: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   750: instanceof 1028
    //   753: ifeq +29 -> 782
    //   756: aload_0
    //   757: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   760: checkcast 1028	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   763: aload_3
    //   764: aload_2
    //   765: aload 4
    //   767: aconst_null
    //   768: iconst_0
    //   769: invokevirtual 1031	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   772: aload_0
    //   773: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   776: checkcast 1028	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   779: invokevirtual 1034	com/tencent/mm/plugin/sns/ui/SnsUploadUI:bKc	()V
    //   782: iconst_1
    //   783: ireturn
    //   784: astore 5
    //   786: ldc 114
    //   788: ldc_w 1036
    //   791: iconst_1
    //   792: anewarray 409	java/lang/Object
    //   795: dup
    //   796: iconst_0
    //   797: aload 5
    //   799: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   802: aastore
    //   803: invokestatic 1038	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   806: aload 4
    //   808: invokevirtual 989	android/media/MediaMetadataRetriever:release	()V
    //   811: goto -111 -> 700
    //   814: astore 4
    //   816: goto -116 -> 700
    //   819: astore_2
    //   820: aload 4
    //   822: invokevirtual 989	android/media/MediaMetadataRetriever:release	()V
    //   825: aload_2
    //   826: athrow
    //   827: aload_0
    //   828: aload_2
    //   829: ldc_w 1040
    //   832: invokevirtual 327	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   835: aload_2
    //   836: ldc_w 1042
    //   839: iconst_0
    //   840: invokevirtual 210	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   843: aload_2
    //   844: ldc_w 1044
    //   847: iconst_0
    //   848: invokevirtual 180	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   851: invokevirtual 1047	com/tencent/mm/plugin/sns/ui/ag:d	(Ljava/util/List;IZ)Z
    //   854: ireturn
    //   855: aload_2
    //   856: ldc_w 1049
    //   859: invokevirtual 1053	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   862: checkcast 1055	com/tencent/mm/plugin/mmsight/SightCaptureResult
    //   865: astore 4
    //   867: aload 4
    //   869: ifnull -813 -> 56
    //   872: aload 4
    //   874: getfield 1058	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfh	Z
    //   877: ifeq +27 -> 904
    //   880: aload 4
    //   882: getfield 1061	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfp	Ljava/lang/String;
    //   885: astore_2
    //   886: aload_2
    //   887: invokestatic 257	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   890: ifne -834 -> 56
    //   893: aload_0
    //   894: aload_2
    //   895: invokestatic 1067	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   898: iconst_0
    //   899: iconst_1
    //   900: invokevirtual 1047	com/tencent/mm/plugin/sns/ui/ag:d	(Ljava/util/List;IZ)Z
    //   903: ireturn
    //   904: aload 4
    //   906: getfield 1070	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfj	Ljava/lang/String;
    //   909: astore 5
    //   911: aload 4
    //   913: getfield 1073	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfk	Ljava/lang/String;
    //   916: astore 6
    //   918: aconst_null
    //   919: astore_3
    //   920: aload_0
    //   921: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   924: invokevirtual 166	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   927: ldc_w 1075
    //   930: aload 4
    //   932: getfield 1073	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfk	Ljava/lang/String;
    //   935: invokevirtual 944	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   938: pop
    //   939: aload 4
    //   941: getfield 1078	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfm	Ljava/lang/String;
    //   944: invokestatic 257	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   947: ifne +61 -> 1008
    //   950: aload 4
    //   952: getfield 1078	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfm	Ljava/lang/String;
    //   955: astore_2
    //   956: aload 4
    //   958: getfield 1082	com/tencent/mm/plugin/mmsight/SightCaptureResult:mfo	Lcom/tencent/mm/protocal/c/avn;
    //   961: invokevirtual 1087	com/tencent/mm/protocal/c/avn:toByteArray	()[B
    //   964: astore 4
    //   966: aload 4
    //   968: astore_3
    //   969: aload_0
    //   970: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   973: instanceof 1028
    //   976: ifeq +30 -> 1006
    //   979: aload_0
    //   980: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   983: checkcast 1028	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   986: aload 5
    //   988: aload 6
    //   990: aload_2
    //   991: aload_3
    //   992: iconst_1
    //   993: invokevirtual 1031	com/tencent/mm/plugin/sns/ui/SnsUploadUI:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    //   996: aload_0
    //   997: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   1000: checkcast 1028	com/tencent/mm/plugin/sns/ui/SnsUploadUI
    //   1003: invokevirtual 1034	com/tencent/mm/plugin/sns/ui/SnsUploadUI:bKc	()V
    //   1006: iconst_1
    //   1007: ireturn
    //   1008: aload 5
    //   1010: invokestatic 974	com/tencent/mm/a/g:bQ	(Ljava/lang/String;)Ljava/lang/String;
    //   1013: astore_2
    //   1014: goto -58 -> 956
    //   1017: astore 4
    //   1019: ldc 114
    //   1021: ldc_w 1089
    //   1024: iconst_1
    //   1025: anewarray 409	java/lang/Object
    //   1028: dup
    //   1029: iconst_0
    //   1030: aload 4
    //   1032: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1035: aastore
    //   1036: invokestatic 719	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1039: goto -70 -> 969
    //   1042: ldc 114
    //   1044: ldc_w 1091
    //   1047: invokestatic 336	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1050: aload_2
    //   1051: ifnonnull +5 -> 1056
    //   1054: iconst_1
    //   1055: ireturn
    //   1056: aload_2
    //   1057: ldc_w 946
    //   1060: invokevirtual 186	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1063: astore_3
    //   1064: ldc 114
    //   1066: new 263	java/lang/StringBuilder
    //   1069: dup
    //   1070: ldc_w 1093
    //   1073: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1076: aload_3
    //   1077: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1083: invokestatic 336	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1086: aload_3
    //   1087: ifnonnull +5 -> 1092
    //   1090: iconst_1
    //   1091: ireturn
    //   1092: aload_3
    //   1093: invokestatic 971	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   1096: ifne +5 -> 1101
    //   1099: iconst_1
    //   1100: ireturn
    //   1101: aload_0
    //   1102: getfield 52	com/tencent/mm/plugin/sns/ui/ag:oSd	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1105: getfield 449	com/tencent/mm/plugin/sns/ui/ag$b:oSo	Ljava/util/ArrayList;
    //   1108: invokevirtual 502	java/util/ArrayList:size	()I
    //   1111: bipush 9
    //   1113: if_icmplt +5 -> 1118
    //   1116: iconst_1
    //   1117: ireturn
    //   1118: aload_2
    //   1119: ldc_w 1042
    //   1122: iconst_0
    //   1123: invokevirtual 210	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1126: istore_1
    //   1127: new 263	java/lang/StringBuilder
    //   1130: dup
    //   1131: ldc_w 380
    //   1134: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1137: new 263	java/lang/StringBuilder
    //   1140: dup
    //   1141: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1144: aload_3
    //   1145: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   1151: invokevirtual 287	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1154: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1157: invokevirtual 292	java/lang/String:getBytes	()[B
    //   1160: invokestatic 298	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   1163: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1169: astore_2
    //   1170: ldc 114
    //   1172: new 263	java/lang/StringBuilder
    //   1175: dup
    //   1176: ldc_w 1095
    //   1179: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1182: aload_3
    //   1183: invokestatic 728	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   1186: invokevirtual 287	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1189: ldc_w 275
    //   1192: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: aload_3
    //   1196: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1202: invokestatic 797	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1205: aload_3
    //   1206: new 263	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1213: invokestatic 269	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   1216: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: aload_2
    //   1220: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1226: invokestatic 390	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   1229: pop2
    //   1230: aload_0
    //   1231: getfield 59	com/tencent/mm/plugin/sns/ui/ag:oSf	Ljava/util/Map;
    //   1234: aload_3
    //   1235: invokeinterface 563 2 0
    //   1240: ifeq +43 -> 1283
    //   1243: aload_0
    //   1244: getfield 59	com/tencent/mm/plugin/sns/ui/ag:oSf	Ljava/util/Map;
    //   1247: new 263	java/lang/StringBuilder
    //   1250: dup
    //   1251: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1254: invokestatic 269	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   1257: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: aload_2
    //   1261: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1267: aload_0
    //   1268: getfield 59	com/tencent/mm/plugin/sns/ui/ag:oSf	Ljava/util/Map;
    //   1271: aload_3
    //   1272: invokeinterface 567 2 0
    //   1277: invokeinterface 143 3 0
    //   1282: pop
    //   1283: new 263	java/lang/StringBuilder
    //   1286: dup
    //   1287: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1290: invokestatic 269	com/tencent/mm/plugin/sns/model/af:getAccSnsTmpPath	()Ljava/lang/String;
    //   1293: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: aload_2
    //   1297: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: astore_2
    //   1304: ldc 114
    //   1306: new 263	java/lang/StringBuilder
    //   1309: dup
    //   1310: ldc_w 333
    //   1313: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1316: aload_2
    //   1317: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1323: invokestatic 336	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1326: aload_0
    //   1327: getfield 52	com/tencent/mm/plugin/sns/ui/ag:oSd	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1330: aload_2
    //   1331: iload_1
    //   1332: iconst_0
    //   1333: invokevirtual 339	com/tencent/mm/plugin/sns/ui/ag$b:o	(Ljava/lang/String;IZ)Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1336: pop
    //   1337: aload_0
    //   1338: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   1341: invokevirtual 166	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1344: ldc_w 321
    //   1347: aload_0
    //   1348: getfield 52	com/tencent/mm/plugin/sns/ui/ag:oSd	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1351: getfield 449	com/tencent/mm/plugin/sns/ui/ag$b:oSo	Ljava/util/ArrayList;
    //   1354: invokevirtual 1098	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1357: pop
    //   1358: aload_0
    //   1359: getfield 445	com/tencent/mm/plugin/sns/ui/ag:oSe	Lcom/tencent/mm/plugin/sns/ui/v;
    //   1362: checkcast 455	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1365: aload_0
    //   1366: getfield 52	com/tencent/mm/plugin/sns/ui/ag:oSd	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1369: getfield 449	com/tencent/mm/plugin/sns/ui/ag$b:oSo	Ljava/util/ArrayList;
    //   1372: invokevirtual 502	java/util/ArrayList:size	()I
    //   1375: invokevirtual 1101	com/tencent/mm/plugin/sns/ui/previewimageview/e:zb	(I)V
    //   1378: aload_0
    //   1379: getfield 445	com/tencent/mm/plugin/sns/ui/ag:oSe	Lcom/tencent/mm/plugin/sns/ui/v;
    //   1382: aload_0
    //   1383: getfield 52	com/tencent/mm/plugin/sns/ui/ag:oSd	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1386: getfield 449	com/tencent/mm/plugin/sns/ui/ag$b:oSo	Ljava/util/ArrayList;
    //   1389: invokeinterface 467 2 0
    //   1394: iconst_1
    //   1395: ireturn
    //   1396: aload_2
    //   1397: ifnonnull +5 -> 1402
    //   1400: iconst_1
    //   1401: ireturn
    //   1402: aload_0
    //   1403: getfield 52	com/tencent/mm/plugin/sns/ui/ag:oSd	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1406: aload_2
    //   1407: ldc_w 1103
    //   1410: invokevirtual 327	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1413: invokevirtual 1107	com/tencent/mm/plugin/sns/ui/ag$b:P	(Ljava/util/ArrayList;)V
    //   1416: aload_0
    //   1417: getfield 75	com/tencent/mm/plugin/sns/ui/ag:bER	Lcom/tencent/mm/ui/MMActivity;
    //   1420: invokevirtual 166	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   1423: ldc_w 321
    //   1426: aload_0
    //   1427: getfield 52	com/tencent/mm/plugin/sns/ui/ag:oSd	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1430: getfield 449	com/tencent/mm/plugin/sns/ui/ag$b:oSo	Ljava/util/ArrayList;
    //   1433: invokevirtual 1098	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   1436: pop
    //   1437: aload_0
    //   1438: getfield 445	com/tencent/mm/plugin/sns/ui/ag:oSe	Lcom/tencent/mm/plugin/sns/ui/v;
    //   1441: checkcast 455	com/tencent/mm/plugin/sns/ui/previewimageview/e
    //   1444: aload_0
    //   1445: getfield 52	com/tencent/mm/plugin/sns/ui/ag:oSd	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1448: getfield 449	com/tencent/mm/plugin/sns/ui/ag$b:oSo	Ljava/util/ArrayList;
    //   1451: invokevirtual 502	java/util/ArrayList:size	()I
    //   1454: invokevirtual 1101	com/tencent/mm/plugin/sns/ui/previewimageview/e:zb	(I)V
    //   1457: aload_0
    //   1458: getfield 445	com/tencent/mm/plugin/sns/ui/ag:oSe	Lcom/tencent/mm/plugin/sns/ui/v;
    //   1461: aload_0
    //   1462: getfield 52	com/tencent/mm/plugin/sns/ui/ag:oSd	Lcom/tencent/mm/plugin/sns/ui/ag$b;
    //   1465: getfield 449	com/tencent/mm/plugin/sns/ui/ag$b:oSo	Ljava/util/ArrayList;
    //   1468: invokeinterface 467 2 0
    //   1473: aload_0
    //   1474: aload_2
    //   1475: ldc_w 1109
    //   1478: iconst_0
    //   1479: invokevirtual 210	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1482: putfield 63	com/tencent/mm/plugin/sns/ui/ag:oSh	I
    //   1485: iconst_1
    //   1486: ireturn
    //   1487: astore 4
    //   1489: goto -789 -> 700
    //   1492: astore_3
    //   1493: goto -668 -> 825
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1496	0	this	ag
    //   0	1496	1	paramInt	int
    //   0	1496	2	paramIntent	Intent
    //   87	1185	3	localObject1	Object
    //   1492	1	3	localException1	Exception
    //   242	565	4	localObject2	Object
    //   814	7	4	localException2	Exception
    //   865	102	4	localObject3	Object
    //   1017	14	4	localException3	Exception
    //   1487	1	4	localException4	Exception
    //   280	404	5	localObject4	Object
    //   784	14	5	localException5	Exception
    //   909	100	5	str1	String
    //   916	73	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   586	591	594	java/lang/Exception
    //   559	573	784	java/lang/Exception
    //   578	586	784	java/lang/Exception
    //   609	695	784	java/lang/Exception
    //   806	811	814	java/lang/Exception
    //   559	573	819	finally
    //   578	586	819	finally
    //   609	695	819	finally
    //   786	806	819	finally
    //   956	966	1017	java/lang/Exception
    //   695	700	1487	java/lang/Exception
    //   820	825	1492	java/lang/Exception
  }
  
  public final boolean d(List<String> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      y.i("MicroMsg.PicWidget", "no image selected");
    }
    while (this.oSd.oSo.size() >= 9) {
      return true;
    }
    paramList = paramList.iterator();
    label45:
    Object localObject;
    String str;
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      if (com.tencent.mm.vfs.e.bK((String)localObject))
      {
        str = "pre_temp_sns_pic" + com.tencent.mm.a.g.o(new StringBuilder().append((String)localObject).append(System.currentTimeMillis()).toString().getBytes());
        com.tencent.mm.plugin.sns.storage.s.ab(af.getAccSnsTmpPath(), (String)localObject, str);
        y.d("MicroMsg.PicWidget", "newPath " + af.getAccSnsTmpPath() + str);
        this.oSd.o(af.getAccSnsTmpPath() + str, paramInt, paramBoolean);
        ((com.tencent.mm.plugin.sns.ui.previewimageview.e)this.oSe).zb(this.oSd.oSo.size());
        this.oSe.setList$22875ea3(this.oSd.oSo);
        this.bER.getIntent().putExtra("sns_kemdia_path_list", this.oSd.oSo);
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b((String)localObject);
        bue localbue = new bue();
        if (!paramBoolean) {
          continue;
        }
        i = 1;
        localbue.tKW = i;
        localbue.tKY = (localb.lastModified() / 1000L);
        localbue.tKX = Exif.fromFile((String)localObject).getUxtimeDatatimeOriginal();
        this.oSg.put(af.getAccSnsTmpPath() + str, localbue);
      }
      catch (Exception localException)
      {
        int i;
        y.e("MicroMsg.PicWidget", "get report info error " + localException.getMessage());
        continue;
      }
      localObject = Exif.fromFile((String)localObject).getLocation();
      if (localObject == null) {
        break label45;
      }
      this.oSf.put(af.getAccSnsTmpPath() + str, localObject);
      break label45;
      break;
      i = 2;
    }
  }
  
  final void yB(int paramInt)
  {
    u localu = new u().uQ();
    localu.cjI = paramInt;
    localu.cie = this.oQO;
    localu.QX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag
 * JD-Core Version:    0.7.0.1
 */