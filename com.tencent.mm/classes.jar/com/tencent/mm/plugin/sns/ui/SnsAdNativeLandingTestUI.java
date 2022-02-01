package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;

public class SnsAdNativeLandingTestUI
  extends MMActivity
{
  private double PGZ;
  private int Qbs;
  private VideoSightView RmJ;
  SnsAdNativeLandingPagesVideoPlayerLoadingBar RmK;
  private int duration;
  private MMHandler mRi;
  private int videoHeight;
  private int videoWidth;
  
  public SnsAdNativeLandingTestUI()
  {
    AppMethodBeat.i(98446);
    this.PGZ = 0.0D;
    this.duration = 0;
    this.mRi = new MMHandler();
    AppMethodBeat.o(98446);
  }
  
  public int getLayoutId()
  {
    return b.g.sns_ad_native_landing_pages_test_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98447);
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    getWindow().setFlags(1024, 1024);
    ((Button)findViewById(b.f.sns_ad_native_landing_pages_test_share_btn)).setOnClickListener(new SnsAdNativeLandingTestUI.1(this));
    paramBundle = (ViewGroup)findViewById(b.f.sns_ad_native_landing_pages_test_root);
    Object localObject2 = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject1 = (WindowManager)getContext().getSystemService("window");
    int i = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
    int j = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
    localObject1 = com.tencent.mm.loader.i.b.bmz() + "/sns_ad_landingpages";
    String str1 = "adId" + "_image_" + MD5Util.getMD5String("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
    String str2 = "adId" + "_stream_" + MD5Util.getMD5String("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
    localObject2 = ((LayoutInflater)localObject2).inflate(b.g.sns_ad_native_landing_pages_item_sight, null);
    ((View)localObject2).setMinimumHeight(j);
    Object localObject3 = (ViewGroup)((View)localObject2).findViewById(b.f.sns_ad_native_landing_pages_item_sight_container);
    this.RmJ = new VideoSightView(getContext());
    this.RmJ.setLoop(false);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject3).addView(this.RmJ, 0, localLayoutParams);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), getContext().getResources().getDimension(b.d.NoPadding));
    this.RmK = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(getContext());
    this.RmK.setVisibility(0);
    this.RmJ.setPlayProgressCallback(true);
    ((ViewGroup)localObject2).addView(this.RmK, (ViewGroup.LayoutParams)localObject3);
    this.RmK.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void blc() {}
      
      public final void tS(int paramAnonymousInt)
      {
        AppMethodBeat.i(98422);
        Log.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this, paramAnonymousInt);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).H(paramAnonymousInt);
        AppMethodBeat.o(98422);
      }
      
      public final void tT(int paramAnonymousInt) {}
    });
    this.RmK.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98423);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).isPlaying()) {
          SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98423);
          return;
          SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
        }
      }
    });
    this.RmK.setIsPlay(this.RmJ.isPlaying());
    this.RmK.setVisibility(0);
    this.RmK.seek(0);
    this.RmJ.setVideoCallback(new i.a()
    {
      public final void Qz()
      {
        AppMethodBeat.i(98425);
        if (SnsAdNativeLandingTestUI.this.RmK.getIsPlay()) {
          SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
        }
        AppMethodBeat.o(98425);
      }
      
      public final void fG(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(98428);
        SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this, paramAnonymousInt1);
        SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
        AppMethodBeat.o(98428);
      }
      
      public final int gw(final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(98427);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98424);
            Log.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + paramAnonymousInt1 + " video time " + paramAnonymousInt2);
            if (paramAnonymousInt2 > 0)
            {
              SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
              SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
            }
            if (SnsAdNativeLandingTestUI.this.RmK.getVideoTotalTime() != paramAnonymousInt2) {
              SnsAdNativeLandingTestUI.this.RmK.setVideoTotalTime(paramAnonymousInt2);
            }
            SnsAdNativeLandingTestUI.this.RmK.seek(paramAnonymousInt1);
            AppMethodBeat.o(98424);
          }
        });
        AppMethodBeat.o(98427);
        return 0;
      }
      
      public final void onCompletion() {}
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(98426);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).stop();
        AppMethodBeat.o(98426);
      }
    });
    this.RmJ.setEnableConfigChanged(false);
    this.RmJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((!"".equals(SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath())) && (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath() != null))
        {
          if (SnsAdNativeLandingTestUI.this.RmK.getVisibility() != 0) {
            break label107;
          }
          SnsAdNativeLandingTestUI.this.RmK.setVisibility(4);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98429);
          return;
          label107:
          SnsAdNativeLandingTestUI.this.RmK.setVisibility(0);
        }
      }
    });
    paramBundle.addView((View)localObject2, new LinearLayout.LayoutParams(i, j));
    this.RmJ.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98430);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        if ((SnsAdNativeLandingTestUI.this.getContext() instanceof MMActivity))
        {
          ((MMActivity)SnsAdNativeLandingTestUI.this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setDrawableWidth(localDisplayMetrics.widthPixels);
        }
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).requestLayout();
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).postInvalidate();
        AppMethodBeat.o(98430);
      }
    });
    new a((String)localObject1, str1, al.fAG(), new SnsAdNativeLandingTestUI.a.a()
    {
      public final void GO(String paramAnonymousString)
      {
        AppMethodBeat.i(98431);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setThumb(BitmapUtil.decodeFile(paramAnonymousString));
        AppMethodBeat.o(98431);
      }
      
      public final void V(String paramAnonymousString, int paramAnonymousInt) {}
      
      public final void abh(String paramAnonymousString) {}
    }).execute(new String[] { "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150" });
    new a((String)localObject1, str2, al.fAG(), new SnsAdNativeLandingTestUI.a.a()
    {
      public final void GO(String paramAnonymousString)
      {
        AppMethodBeat.i(98434);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setVideoPath(paramAnonymousString);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setLoop(true);
        if (SnsAdNativeLandingTestUI.this.RmK.getIsPlay())
        {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).H(SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this));
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).start();
        }
        AppMethodBeat.o(98434);
      }
      
      public final void V(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(98432);
        if (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).isPlaying())
        {
          AppMethodBeat.o(98432);
          return;
        }
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setLoop(false);
        if (!paramAnonymousString.equals(SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath())) {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setVideoPath(paramAnonymousString);
        }
        if (SnsAdNativeLandingTestUI.this.RmK.getIsPlay())
        {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).H(SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this));
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).start();
        }
        AppMethodBeat.o(98432);
      }
      
      public final void abh(String paramAnonymousString)
      {
        AppMethodBeat.i(98433);
        Log.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", paramAnonymousString);
        AppMethodBeat.o(98433);
      }
    }, 409600).execute(new String[] { "http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400" });
    AppMethodBeat.o(98447);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends AsyncTask<String, Void, Void>
  {
    private static Set<String> RmP;
    private static byte[] RmQ;
    final String QWS;
    final String QWT;
    final int QWV;
    final String QWW;
    final a RmR;
    final String fileName;
    final String filePath;
    final MMHandler handler;
    
    static
    {
      AppMethodBeat.i(98445);
      RmP = new HashSet();
      RmQ = new byte[0];
      AppMethodBeat.o(98445);
    }
    
    public a(String paramString1, String paramString2, MMHandler paramMMHandler, a parama)
    {
      this(paramString1, paramString2, paramMMHandler, parama, 0);
    }
    
    public a(String paramString1, String paramString2, final MMHandler paramMMHandler, final a parama, int paramInt)
    {
      AppMethodBeat.i(98442);
      com.tencent.mm.vfs.y.bDX(paramString1);
      this.QWW = paramString1;
      this.fileName = paramString2;
      this.filePath = (paramString1 + "/" + paramString2);
      this.QWT = "temp_".concat(String.valueOf(paramString2));
      this.QWS = (paramString1 + "/" + this.QWT);
      this.handler = paramMMHandler;
      this.QWV = paramInt;
      this.RmR = new a()
      {
        public final void GO(final String paramAnonymousString)
        {
          AppMethodBeat.i(98441);
          paramMMHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98438);
              SnsAdNativeLandingTestUI.a.1.this.RmS.GO(paramAnonymousString);
              AppMethodBeat.o(98438);
            }
          });
          AppMethodBeat.o(98441);
        }
        
        public final void V(final String paramAnonymousString, final int paramAnonymousInt)
        {
          AppMethodBeat.i(98439);
          paramMMHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98436);
              SnsAdNativeLandingTestUI.a.1.this.RmS.V(paramAnonymousString, paramAnonymousInt);
              AppMethodBeat.o(98436);
            }
          });
          AppMethodBeat.o(98439);
        }
        
        public final void abh(final String paramAnonymousString)
        {
          AppMethodBeat.i(98440);
          paramMMHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98437);
              SnsAdNativeLandingTestUI.a.1.this.RmS.abh(paramAnonymousString);
              AppMethodBeat.o(98437);
            }
          });
          AppMethodBeat.o(98440);
        }
      };
      AppMethodBeat.o(98442);
    }
    
    /* Error */
    private Void Q(String... paramVarArgs)
    {
      // Byte code:
      //   0: ldc 120
      //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmQ	[B
      //   8: astore 5
      //   10: aload 5
      //   12: monitorenter
      //   13: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmP	Ljava/util/Set;
      //   16: aload_1
      //   17: iconst_0
      //   18: aaload
      //   19: invokeinterface 126 2 0
      //   24: ifeq +13 -> 37
      //   27: aload 5
      //   29: monitorexit
      //   30: ldc 120
      //   32: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   35: aconst_null
      //   36: areturn
      //   37: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmP	Ljava/util/Set;
      //   40: aload_1
      //   41: iconst_0
      //   42: aaload
      //   43: invokeinterface 129 2 0
      //   48: pop
      //   49: aload 5
      //   51: monitorexit
      //   52: aload_0
      //   53: getfield 88	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
      //   56: invokestatic 132	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
      //   59: ifeq +68 -> 127
      //   62: aload_0
      //   63: getfield 113	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmR	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
      //   66: aload_0
      //   67: getfield 88	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
      //   70: invokeinterface 136 2 0
      //   75: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmQ	[B
      //   78: astore 5
      //   80: aload 5
      //   82: monitorenter
      //   83: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmP	Ljava/util/Set;
      //   86: aload_1
      //   87: iconst_0
      //   88: aaload
      //   89: invokeinterface 139 2 0
      //   94: pop
      //   95: aload 5
      //   97: monitorexit
      //   98: ldc 120
      //   100: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   103: aconst_null
      //   104: areturn
      //   105: astore_1
      //   106: aload 5
      //   108: monitorexit
      //   109: ldc 120
      //   111: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   114: aload_1
      //   115: athrow
      //   116: astore_1
      //   117: aload 5
      //   119: monitorexit
      //   120: ldc 120
      //   122: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   125: aload_1
      //   126: athrow
      //   127: aload_0
      //   128: getfield 104	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:QWS	Ljava/lang/String;
      //   131: invokestatic 132	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
      //   134: ifeq +11 -> 145
      //   137: aload_0
      //   138: getfield 104	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:QWS	Ljava/lang/String;
      //   141: invokestatic 142	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
      //   144: pop
      //   145: new 144	java/net/URL
      //   148: dup
      //   149: aload_1
      //   150: iconst_0
      //   151: aaload
      //   152: invokespecial 146	java/net/URL:<init>	(Ljava/lang/String;)V
      //   155: invokevirtual 150	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   158: checkcast 152	java/net/HttpURLConnection
      //   161: astore 5
      //   163: aload 5
      //   165: invokevirtual 155	java/net/HttpURLConnection:connect	()V
      //   168: aload 5
      //   170: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
      //   173: sipush 200
      //   176: if_icmpeq +119 -> 295
      //   179: aload_0
      //   180: getfield 113	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmR	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
      //   183: new 75	java/lang/StringBuilder
      //   186: dup
      //   187: ldc 161
      //   189: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   192: aload 5
      //   194: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
      //   197: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   200: ldc 167
      //   202: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   205: aload 5
      //   207: invokevirtual 170	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
      //   210: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   213: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   216: invokeinterface 173 2 0
      //   221: aload 5
      //   223: ifnull +16 -> 239
      //   226: aload 5
      //   228: invokevirtual 177	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   231: invokevirtual 182	java/io/InputStream:close	()V
      //   234: aload 5
      //   236: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
      //   239: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmQ	[B
      //   242: astore 5
      //   244: aload 5
      //   246: monitorenter
      //   247: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmP	Ljava/util/Set;
      //   250: aload_1
      //   251: iconst_0
      //   252: aaload
      //   253: invokeinterface 139 2 0
      //   258: pop
      //   259: aload 5
      //   261: monitorexit
      //   262: ldc 120
      //   264: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   267: aconst_null
      //   268: areturn
      //   269: astore 6
      //   271: ldc 187
      //   273: aload 6
      //   275: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   278: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   281: goto -47 -> 234
      //   284: astore_1
      //   285: aload 5
      //   287: monitorexit
      //   288: ldc 120
      //   290: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   293: aload_1
      //   294: athrow
      //   295: aload 5
      //   297: invokevirtual 199	java/net/HttpURLConnection:getContentLength	()I
      //   300: pop
      //   301: aload 5
      //   303: invokevirtual 177	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   306: astore 8
      //   308: aload_0
      //   309: getfield 104	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:QWS	Ljava/lang/String;
      //   312: iconst_0
      //   313: invokestatic 203	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   316: astore 7
      //   318: sipush 4096
      //   321: newarray byte
      //   323: astore 6
      //   325: iconst_0
      //   326: istore_3
      //   327: iconst_0
      //   328: istore_2
      //   329: aload 8
      //   331: aload 6
      //   333: invokevirtual 207	java/io/InputStream:read	([B)I
      //   336: istore 4
      //   338: iload 4
      //   340: iconst_m1
      //   341: if_icmpeq +54 -> 395
      //   344: aload 7
      //   346: aload 6
      //   348: iconst_0
      //   349: iload 4
      //   351: invokevirtual 213	java/io/OutputStream:write	([BII)V
      //   354: iload 4
      //   356: iload_2
      //   357: iadd
      //   358: istore_2
      //   359: aload_0
      //   360: getfield 108	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:QWV	I
      //   363: ifeq +492 -> 855
      //   366: iload_2
      //   367: iload_3
      //   368: isub
      //   369: aload_0
      //   370: getfield 108	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:QWV	I
      //   373: if_icmplt +482 -> 855
      //   376: aload_0
      //   377: getfield 113	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmR	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
      //   380: aload_0
      //   381: getfield 104	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:QWS	Ljava/lang/String;
      //   384: iload_2
      //   385: invokeinterface 217 3 0
      //   390: iload_2
      //   391: istore_3
      //   392: goto -63 -> 329
      //   395: aload_0
      //   396: getfield 104	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:QWS	Ljava/lang/String;
      //   399: aload_0
      //   400: getfield 88	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
      //   403: invokestatic 221	com/tencent/mm/vfs/y:qn	(Ljava/lang/String;Ljava/lang/String;)Z
      //   406: pop
      //   407: aload_0
      //   408: getfield 113	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmR	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
      //   411: aload_0
      //   412: getfield 88	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
      //   415: invokeinterface 136 2 0
      //   420: aload 7
      //   422: ifnull +8 -> 430
      //   425: aload 7
      //   427: invokevirtual 222	java/io/OutputStream:close	()V
      //   430: aload 8
      //   432: ifnull +8 -> 440
      //   435: aload 8
      //   437: invokevirtual 182	java/io/InputStream:close	()V
      //   440: aload 5
      //   442: ifnull +16 -> 458
      //   445: aload 5
      //   447: invokevirtual 177	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   450: invokevirtual 182	java/io/InputStream:close	()V
      //   453: aload 5
      //   455: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
      //   458: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmQ	[B
      //   461: astore 5
      //   463: aload 5
      //   465: monitorenter
      //   466: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmP	Ljava/util/Set;
      //   469: aload_1
      //   470: iconst_0
      //   471: aaload
      //   472: invokeinterface 139 2 0
      //   477: pop
      //   478: aload 5
      //   480: monitorexit
      //   481: ldc 120
      //   483: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   486: aconst_null
      //   487: areturn
      //   488: astore 6
      //   490: ldc 187
      //   492: aload 6
      //   494: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   497: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   500: goto -47 -> 453
      //   503: astore_1
      //   504: aload 5
      //   506: monitorexit
      //   507: ldc 120
      //   509: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   512: aload_1
      //   513: athrow
      //   514: astore 5
      //   516: aconst_null
      //   517: astore 6
      //   519: aconst_null
      //   520: astore 7
      //   522: aconst_null
      //   523: astore 8
      //   525: aload_0
      //   526: getfield 113	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmR	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
      //   529: aload 5
      //   531: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   534: invokeinterface 173 2 0
      //   539: aload 7
      //   541: ifnull +8 -> 549
      //   544: aload 7
      //   546: invokevirtual 222	java/io/OutputStream:close	()V
      //   549: aload 8
      //   551: ifnull +8 -> 559
      //   554: aload 8
      //   556: invokevirtual 182	java/io/InputStream:close	()V
      //   559: aload 6
      //   561: ifnull +16 -> 577
      //   564: aload 6
      //   566: invokevirtual 177	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   569: invokevirtual 182	java/io/InputStream:close	()V
      //   572: aload 6
      //   574: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
      //   577: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmQ	[B
      //   580: astore 5
      //   582: aload 5
      //   584: monitorenter
      //   585: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmP	Ljava/util/Set;
      //   588: aload_1
      //   589: iconst_0
      //   590: aaload
      //   591: invokeinterface 139 2 0
      //   596: pop
      //   597: aload 5
      //   599: monitorexit
      //   600: ldc 120
      //   602: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   605: aconst_null
      //   606: areturn
      //   607: astore 5
      //   609: ldc 187
      //   611: aload 5
      //   613: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   616: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   619: goto -47 -> 572
      //   622: astore_1
      //   623: aload 5
      //   625: monitorexit
      //   626: ldc 120
      //   628: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   631: aload_1
      //   632: athrow
      //   633: astore 5
      //   635: aconst_null
      //   636: astore 6
      //   638: aconst_null
      //   639: astore 7
      //   641: aconst_null
      //   642: astore 8
      //   644: aload 7
      //   646: ifnull +8 -> 654
      //   649: aload 7
      //   651: invokevirtual 222	java/io/OutputStream:close	()V
      //   654: aload 8
      //   656: ifnull +8 -> 664
      //   659: aload 8
      //   661: invokevirtual 182	java/io/InputStream:close	()V
      //   664: aload 6
      //   666: ifnull +16 -> 682
      //   669: aload 6
      //   671: invokevirtual 177	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   674: invokevirtual 182	java/io/InputStream:close	()V
      //   677: aload 6
      //   679: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
      //   682: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmQ	[B
      //   685: astore 6
      //   687: aload 6
      //   689: monitorenter
      //   690: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:RmP	Ljava/util/Set;
      //   693: aload_1
      //   694: iconst_0
      //   695: aaload
      //   696: invokeinterface 139 2 0
      //   701: pop
      //   702: aload 6
      //   704: monitorexit
      //   705: ldc 120
      //   707: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   710: aload 5
      //   712: athrow
      //   713: astore 7
      //   715: ldc 187
      //   717: aload 7
      //   719: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   722: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   725: goto -48 -> 677
      //   728: astore_1
      //   729: aload 6
      //   731: monitorexit
      //   732: ldc 120
      //   734: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   737: aload_1
      //   738: athrow
      //   739: astore 7
      //   741: goto -77 -> 664
      //   744: astore 9
      //   746: aload 5
      //   748: astore 6
      //   750: aconst_null
      //   751: astore 7
      //   753: aconst_null
      //   754: astore 8
      //   756: aload 9
      //   758: astore 5
      //   760: goto -116 -> 644
      //   763: astore 9
      //   765: aload 5
      //   767: astore 6
      //   769: aconst_null
      //   770: astore 7
      //   772: aload 9
      //   774: astore 5
      //   776: goto -132 -> 644
      //   779: astore 9
      //   781: aload 5
      //   783: astore 6
      //   785: aload 9
      //   787: astore 5
      //   789: goto -145 -> 644
      //   792: astore 5
      //   794: goto -150 -> 644
      //   797: astore 5
      //   799: goto -240 -> 559
      //   802: astore 9
      //   804: aload 5
      //   806: astore 6
      //   808: aconst_null
      //   809: astore 7
      //   811: aconst_null
      //   812: astore 8
      //   814: aload 9
      //   816: astore 5
      //   818: goto -293 -> 525
      //   821: astore 9
      //   823: aload 5
      //   825: astore 6
      //   827: aconst_null
      //   828: astore 7
      //   830: aload 9
      //   832: astore 5
      //   834: goto -309 -> 525
      //   837: astore 9
      //   839: aload 5
      //   841: astore 6
      //   843: aload 9
      //   845: astore 5
      //   847: goto -322 -> 525
      //   850: astore 6
      //   852: goto -412 -> 440
      //   855: goto -526 -> 329
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	858	0	this	a
      //   0	858	1	paramVarArgs	String[]
      //   328	63	2	i	int
      //   326	66	3	j	int
      //   336	22	4	k	int
      //   8	497	5	localObject1	Object
      //   514	16	5	localException1	java.lang.Exception
      //   580	18	5	arrayOfByte1	byte[]
      //   607	17	5	localException2	java.lang.Exception
      //   633	114	5	localObject2	Object
      //   758	30	5	localObject3	Object
      //   792	1	5	localObject4	Object
      //   797	8	5	localIOException1	java.io.IOException
      //   816	30	5	localObject5	Object
      //   269	5	6	localException3	java.lang.Exception
      //   323	24	6	arrayOfByte2	byte[]
      //   488	5	6	localException4	java.lang.Exception
      //   850	1	6	localIOException2	java.io.IOException
      //   316	334	7	localOutputStream	java.io.OutputStream
      //   713	5	7	localException5	java.lang.Exception
      //   739	1	7	localIOException3	java.io.IOException
      //   751	78	7	localObject7	Object
      //   306	507	8	localInputStream	java.io.InputStream
      //   744	13	9	localObject8	Object
      //   763	10	9	localObject9	Object
      //   779	7	9	localObject10	Object
      //   802	13	9	localException6	java.lang.Exception
      //   821	10	9	localException7	java.lang.Exception
      //   837	7	9	localException8	java.lang.Exception
      // Exception table:
      //   from	to	target	type
      //   13	30	105	finally
      //   37	52	105	finally
      //   83	98	116	finally
      //   226	234	269	java/lang/Exception
      //   247	262	284	finally
      //   445	453	488	java/lang/Exception
      //   466	481	503	finally
      //   52	75	514	java/lang/Exception
      //   127	145	514	java/lang/Exception
      //   145	163	514	java/lang/Exception
      //   564	572	607	java/lang/Exception
      //   585	600	622	finally
      //   52	75	633	finally
      //   127	145	633	finally
      //   145	163	633	finally
      //   669	677	713	java/lang/Exception
      //   690	705	728	finally
      //   649	654	739	java/io/IOException
      //   659	664	739	java/io/IOException
      //   163	221	744	finally
      //   295	308	744	finally
      //   308	318	763	finally
      //   318	325	779	finally
      //   329	338	779	finally
      //   344	354	779	finally
      //   359	390	779	finally
      //   395	420	779	finally
      //   525	539	792	finally
      //   544	549	797	java/io/IOException
      //   554	559	797	java/io/IOException
      //   163	221	802	java/lang/Exception
      //   295	308	802	java/lang/Exception
      //   308	318	821	java/lang/Exception
      //   318	325	837	java/lang/Exception
      //   329	338	837	java/lang/Exception
      //   344	354	837	java/lang/Exception
      //   359	390	837	java/lang/Exception
      //   395	420	837	java/lang/Exception
      //   425	430	850	java/io/IOException
      //   435	440	850	java/io/IOException
    }
    
    static abstract interface a
    {
      public abstract void GO(String paramString);
      
      public abstract void V(String paramString, int paramInt);
      
      public abstract void abh(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI
 * JD-Core Version:    0.7.0.1
 */