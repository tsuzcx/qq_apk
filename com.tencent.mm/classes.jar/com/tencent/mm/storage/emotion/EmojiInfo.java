package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gif.i;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.vfs.b;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;

public class EmojiInfo
  extends bb
  implements Parcelable, k
{
  public static int APx;
  public static final Parcelable.Creator<EmojiInfo> CREATOR;
  public static int TYPE_TEXT;
  protected static c.a info;
  public static int yPA;
  public static int yPc;
  public static int yPg;
  public static String yPh;
  public static int yPi;
  public static int yPj;
  public static int yPk;
  public static int yPl;
  public static int yPm;
  public static int yPn;
  public static int yPo;
  public static int yPp;
  public static int yPq;
  public static int yPr;
  public static int yPs;
  public static int yPt;
  public static int yPu;
  public static int yPv;
  public static int yPw;
  public static int yPx;
  public static int yPy;
  public static int yPz;
  private final String pIR;
  public String talker;
  
  static
  {
    AppMethodBeat.i(62792);
    yPh = ".gif";
    yPi = 17;
    yPj = 32;
    yPk = 49;
    yPl = 50;
    yPg = 65;
    yPm = 81;
    yPc = -1;
    yPn = 1;
    yPo = 2;
    yPp = 3;
    TYPE_TEXT = 4;
    yPq = 10;
    yPr = 11;
    yPs = 0;
    yPt = 1;
    yPu = 3;
    yPv = 4;
    yPw = 8;
    yPx = 0;
    yPy = 1;
    yPz = 0;
    yPA = 1;
    APx = 1;
    c.a locala = new c.a();
    locala.yrK = new Field[44];
    locala.columns = new String[45];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "md5";
    locala.yrM.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.yrL = "md5";
    locala.columns[1] = "svrid";
    locala.yrM.put("svrid", "TEXT");
    localStringBuilder.append(" svrid TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "catalog";
    locala.yrM.put("catalog", "INTEGER");
    localStringBuilder.append(" catalog INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "type";
    locala.yrM.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "size";
    locala.yrM.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "start";
    locala.yrM.put("start", "INTEGER");
    localStringBuilder.append(" start INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "state";
    locala.yrM.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "name";
    locala.yrM.put("name", "TEXT");
    localStringBuilder.append(" name TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "content";
    locala.yrM.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "reserved1";
    locala.yrM.put("reserved1", "TEXT");
    localStringBuilder.append(" reserved1 TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "reserved2";
    locala.yrM.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "reserved3";
    locala.yrM.put("reserved3", "INTEGER");
    localStringBuilder.append(" reserved3 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "reserved4";
    locala.yrM.put("reserved4", "INTEGER");
    localStringBuilder.append(" reserved4 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "app_id";
    locala.yrM.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "groupId";
    locala.yrM.put("groupId", "TEXT default '' ");
    localStringBuilder.append(" groupId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "lastUseTime";
    locala.yrM.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localStringBuilder.append(", ");
    locala.columns[16] = "framesInfo";
    locala.yrM.put("framesInfo", "TEXT default '' ");
    localStringBuilder.append(" framesInfo TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "idx";
    locala.yrM.put("idx", "INTEGER default '0' ");
    localStringBuilder.append(" idx INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "temp";
    locala.yrM.put("temp", "INTEGER default '0' ");
    localStringBuilder.append(" temp INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "source";
    locala.yrM.put("source", "INTEGER default '0' ");
    localStringBuilder.append(" source INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "needupload";
    locala.yrM.put("needupload", "INTEGER default '0' ");
    localStringBuilder.append(" needupload INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "designerID";
    locala.yrM.put("designerID", "TEXT");
    localStringBuilder.append(" designerID TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "thumbUrl";
    locala.yrM.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "cdnUrl";
    locala.yrM.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "encrypturl";
    locala.yrM.put("encrypturl", "TEXT");
    localStringBuilder.append(" encrypturl TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "aeskey";
    locala.yrM.put("aeskey", "TEXT");
    localStringBuilder.append(" aeskey TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "width";
    locala.yrM.put("width", "INTEGER default '0' ");
    localStringBuilder.append(" width INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[27] = "height";
    locala.yrM.put("height", "INTEGER default '0' ");
    localStringBuilder.append(" height INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[28] = "externUrl";
    locala.yrM.put("externUrl", "TEXT");
    localStringBuilder.append(" externUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "externMd5";
    locala.yrM.put("externMd5", "TEXT");
    localStringBuilder.append(" externMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "activityid";
    locala.yrM.put("activityid", "TEXT");
    localStringBuilder.append(" activityid TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "tpurl";
    locala.yrM.put("tpurl", "TEXT");
    localStringBuilder.append(" tpurl TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "tpauthkey";
    locala.yrM.put("tpauthkey", "TEXT");
    localStringBuilder.append(" tpauthkey TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "wxamMd5";
    locala.yrM.put("wxamMd5", "TEXT");
    localStringBuilder.append(" wxamMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "attachedText";
    locala.yrM.put("attachedText", "TEXT");
    localStringBuilder.append(" attachedText TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "captureStatus";
    locala.yrM.put("captureStatus", "INTEGER default '0' ");
    localStringBuilder.append(" captureStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[36] = "attachedEmojiMD5";
    locala.yrM.put("attachedEmojiMD5", "BLOB default '' ");
    localStringBuilder.append(" attachedEmojiMD5 BLOB default '' ");
    localStringBuilder.append(", ");
    locala.columns[37] = "imitateMd5";
    locala.yrM.put("imitateMd5", "TEXT");
    localStringBuilder.append(" imitateMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[38] = "captureUploadErrCode";
    locala.yrM.put("captureUploadErrCode", "INTEGER default '0' ");
    localStringBuilder.append(" captureUploadErrCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[39] = "captureUploadCounter";
    locala.yrM.put("captureUploadCounter", "INTEGER default '0' ");
    localStringBuilder.append(" captureUploadCounter INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[40] = "captureEnterTime";
    locala.yrM.put("captureEnterTime", "LONG");
    localStringBuilder.append(" captureEnterTime LONG");
    localStringBuilder.append(", ");
    locala.columns[41] = "lensId";
    locala.yrM.put("lensId", "TEXT");
    localStringBuilder.append(" lensId TEXT");
    localStringBuilder.append(", ");
    locala.columns[42] = "attachTextColor";
    locala.yrM.put("attachTextColor", "TEXT");
    localStringBuilder.append(" attachTextColor TEXT");
    localStringBuilder.append(", ");
    locala.columns[43] = "captureScene";
    locala.yrM.put("captureScene", "INTEGER");
    localStringBuilder.append(" captureScene INTEGER");
    locala.columns[44] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new EmojiInfo.1();
    AppMethodBeat.o(62792);
  }
  
  public EmojiInfo()
  {
    AppMethodBeat.i(62765);
    StringBuilder localStringBuilder;
    if (((h)g.RI().Rj()).SD())
    {
      localStringBuilder = new StringBuilder();
      g.RM();
    }
    for (this.pIR = (g.RL().eHR + "emoji/");; this.pIR = (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().getAccPath() + "emoji/"))
    {
      reset();
      AppMethodBeat.o(62765);
      return;
    }
  }
  
  protected EmojiInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(62791);
    this.pIR = paramParcel.readString();
    this.field_md5 = paramParcel.readString();
    this.field_svrid = paramParcel.readString();
    this.field_catalog = paramParcel.readInt();
    this.field_type = paramParcel.readInt();
    this.field_size = paramParcel.readInt();
    this.field_start = paramParcel.readInt();
    this.field_state = paramParcel.readInt();
    this.field_name = paramParcel.readString();
    this.field_content = paramParcel.readString();
    this.field_reserved1 = paramParcel.readString();
    this.field_reserved2 = paramParcel.readString();
    this.field_reserved3 = paramParcel.readInt();
    this.field_reserved4 = paramParcel.readInt();
    this.field_app_id = paramParcel.readString();
    this.field_groupId = paramParcel.readString();
    this.field_lastUseTime = paramParcel.readLong();
    this.field_framesInfo = paramParcel.readString();
    this.field_idx = paramParcel.readInt();
    this.field_temp = paramParcel.readInt();
    this.field_source = paramParcel.readInt();
    this.field_needupload = paramParcel.readInt();
    this.field_designerID = paramParcel.readString();
    this.field_thumbUrl = paramParcel.readString();
    this.field_cdnUrl = paramParcel.readString();
    this.field_encrypturl = paramParcel.readString();
    this.field_aeskey = paramParcel.readString();
    this.field_width = paramParcel.readInt();
    this.field_height = paramParcel.readInt();
    this.field_activityid = paramParcel.readString();
    this.systemRowid = paramParcel.readLong();
    this.field_wxamMd5 = paramParcel.readString();
    this.field_attachedText = paramParcel.readString();
    this.field_captureStatus = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.field_attachedEmojiMD5 = new byte[i];
      paramParcel.readByteArray(this.field_attachedEmojiMD5);
    }
    this.field_imitateMd5 = paramParcel.readString();
    this.field_captureUploadErrCode = paramParcel.readInt();
    this.field_captureUploadCounter = paramParcel.readInt();
    this.field_captureEnterTime = paramParcel.readLong();
    this.field_lensId = paramParcel.readString();
    this.field_attachTextColor = paramParcel.readString();
    this.field_captureScene = paramParcel.readInt();
    this.field_externMd5 = paramParcel.readString();
    AppMethodBeat.o(62791);
  }
  
  public EmojiInfo(String paramString)
  {
    AppMethodBeat.i(62766);
    this.pIR = paramString;
    reset();
    AppMethodBeat.o(62766);
  }
  
  public static boolean NB(int paramInt)
  {
    return (paramInt == yPl) || (paramInt == yPk);
  }
  
  public static InputStream bI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(62772);
    if ((paramContext == null) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(62772);
      return null;
    }
    try
    {
      paramString = paramString.split("\\.")[0];
      ab.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", new Object[] { paramString });
      int i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
      paramContext = paramContext.getResources().openRawResource(i);
      AppMethodBeat.o(62772);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(62772);
    }
    return null;
  }
  
  public static String dQD()
  {
    AppMethodBeat.i(62786);
    String str = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().getAccPath() + "emoji/";
    AppMethodBeat.o(62786);
    return str;
  }
  
  public final String Al()
  {
    if (this.field_md5 == null) {
      return "";
    }
    return this.field_md5;
  }
  
  public final void NC(int paramInt)
  {
    this.field_catalog = paramInt;
  }
  
  public final void a(EmojiInfo.a parama)
  {
    AppMethodBeat.i(62780);
    this.field_captureStatus = parama.ordinal();
    AppMethodBeat.o(62780);
  }
  
  public final void a(EmojiInfo.b paramb)
  {
    AppMethodBeat.i(62781);
    this.field_captureUploadErrCode = paramb.ordinal();
    AppMethodBeat.o(62781);
  }
  
  /* Error */
  public final void am(java.util.ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: ldc_w 635
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 637	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 638	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_2
    //   14: new 640	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 643	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 6
    //   24: aload 6
    //   26: astore 4
    //   28: aload_2
    //   29: astore_3
    //   30: aload 6
    //   32: aload_1
    //   33: invokevirtual 647	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   36: aload 6
    //   38: astore 4
    //   40: aload_2
    //   41: astore_3
    //   42: aload_0
    //   43: aload_2
    //   44: invokevirtual 651	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   47: putfield 527	com/tencent/mm/storage/emotion/EmojiInfo:field_attachedEmojiMD5	[B
    //   50: aload 6
    //   52: invokevirtual 654	java/io/ObjectOutputStream:close	()V
    //   55: aload_2
    //   56: invokevirtual 655	java/io/ByteArrayOutputStream:close	()V
    //   59: ldc_w 635
    //   62: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: astore_1
    //   67: ldc_w 578
    //   70: new 123	java/lang/StringBuilder
    //   73: dup
    //   74: ldc_w 657
    //   77: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: goto -38 -> 55
    //   96: astore_1
    //   97: ldc_w 578
    //   100: new 123	java/lang/StringBuilder
    //   103: dup
    //   104: ldc_w 665
    //   107: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload_1
    //   111: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: ldc_w 635
    //   126: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: return
    //   130: astore 5
    //   132: aconst_null
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_1
    //   137: astore 4
    //   139: aload_2
    //   140: astore_3
    //   141: ldc_w 578
    //   144: new 123	java/lang/StringBuilder
    //   147: dup
    //   148: ldc_w 667
    //   151: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload 5
    //   156: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 654	java/io/ObjectOutputStream:close	()V
    //   176: aload_2
    //   177: ifnull +7 -> 184
    //   180: aload_2
    //   181: invokevirtual 655	java/io/ByteArrayOutputStream:close	()V
    //   184: ldc_w 635
    //   187: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: return
    //   191: astore_1
    //   192: ldc_w 578
    //   195: new 123	java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w 657
    //   202: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: aload_1
    //   206: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: goto -42 -> 176
    //   221: astore_1
    //   222: ldc_w 578
    //   225: new 123	java/lang/StringBuilder
    //   228: dup
    //   229: ldc_w 665
    //   232: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload_1
    //   236: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   239: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: ldc_w 635
    //   251: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: return
    //   255: astore_1
    //   256: aconst_null
    //   257: astore 4
    //   259: aconst_null
    //   260: astore_2
    //   261: aload 4
    //   263: ifnull +8 -> 271
    //   266: aload 4
    //   268: invokevirtual 654	java/io/ObjectOutputStream:close	()V
    //   271: aload_2
    //   272: ifnull +7 -> 279
    //   275: aload_2
    //   276: invokevirtual 655	java/io/ByteArrayOutputStream:close	()V
    //   279: ldc_w 635
    //   282: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: aload_1
    //   286: athrow
    //   287: astore_3
    //   288: ldc_w 578
    //   291: new 123	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 657
    //   298: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: aload_3
    //   302: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: goto -43 -> 271
    //   317: astore_2
    //   318: ldc_w 578
    //   321: new 123	java/lang/StringBuilder
    //   324: dup
    //   325: ldc_w 665
    //   328: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: aload_2
    //   332: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: goto -65 -> 279
    //   347: astore_1
    //   348: aconst_null
    //   349: astore 4
    //   351: goto -90 -> 261
    //   354: astore_1
    //   355: aload_3
    //   356: astore_2
    //   357: goto -96 -> 261
    //   360: astore 5
    //   362: aconst_null
    //   363: astore_1
    //   364: goto -228 -> 136
    //   367: astore 5
    //   369: aload 6
    //   371: astore_1
    //   372: goto -236 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	EmojiInfo
    //   0	375	1	paramArrayList	java.util.ArrayList<String>
    //   13	263	2	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   317	15	2	localException1	Exception
    //   356	1	2	localObject1	Object
    //   29	112	3	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   287	69	3	localException2	Exception
    //   26	324	4	localObject2	Object
    //   130	25	5	localException3	Exception
    //   360	1	5	localException4	Exception
    //   367	1	5	localException5	Exception
    //   22	348	6	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	55	66	java/lang/Exception
    //   55	59	96	java/lang/Exception
    //   6	14	130	java/lang/Exception
    //   172	176	191	java/lang/Exception
    //   180	184	221	java/lang/Exception
    //   6	14	255	finally
    //   266	271	287	java/lang/Exception
    //   275	279	317	java/lang/Exception
    //   14	24	347	finally
    //   30	36	354	finally
    //   42	50	354	finally
    //   141	168	354	finally
    //   14	24	360	java/lang/Exception
    //   30	36	367	java/lang/Exception
    //   42	50	367	java/lang/Exception
  }
  
  public final void avG(String paramString)
  {
    this.field_groupId = paramString;
  }
  
  public final String avS()
  {
    return this.field_groupId;
  }
  
  public final boolean cC(Object paramObject)
  {
    AppMethodBeat.i(62788);
    if ((paramObject != null) && ((paramObject instanceof EmojiInfo)) && (((EmojiInfo)paramObject).Al().equalsIgnoreCase(this.field_md5)))
    {
      AppMethodBeat.o(62788);
      return true;
    }
    AppMethodBeat.o(62788);
    return false;
  }
  
  public final boolean cZP()
  {
    AppMethodBeat.i(62779);
    if (Al().length() == 32)
    {
      AppMethodBeat.o(62779);
      return true;
    }
    AppMethodBeat.o(62779);
    return false;
  }
  
  public final String dQB()
  {
    String str = null;
    AppMethodBeat.i(62784);
    if ((bo.isNullOrNil(this.field_groupId)) && (bo.isNullOrNil(this.field_md5)))
    {
      ab.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. product id and md5 are null.");
      AppMethodBeat.o(62784);
      return null;
    }
    if (!bo.isNullOrNil(this.field_md5)) {
      if ((!bo.isNullOrNil(this.field_groupId)) && (!bo.isEqual(this.field_groupId, "capture"))) {
        break label111;
      }
    }
    label111:
    for (str = this.pIR + this.field_md5;; str = this.pIR + this.field_groupId + "/" + this.field_md5)
    {
      AppMethodBeat.o(62784);
      return str;
    }
  }
  
  public final String dQC()
  {
    AppMethodBeat.i(62785);
    String str = dQB();
    if (str == null)
    {
      AppMethodBeat.o(62785);
      return null;
    }
    str = str + "_cover";
    AppMethodBeat.o(62785);
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final EmojiInfo.b dzA()
  {
    switch (this.field_captureUploadErrCode)
    {
    default: 
      return EmojiInfo.b.yPN;
    case 0: 
      return EmojiInfo.b.yPH;
    case 1: 
      return EmojiInfo.b.yPI;
    case 2: 
      return EmojiInfo.b.yPJ;
    case 3: 
      return EmojiInfo.b.yPK;
    case 4: 
      return EmojiInfo.b.yPL;
    case 5: 
      return EmojiInfo.b.yPM;
    case 6: 
      return EmojiInfo.b.yPN;
    case 7: 
      return EmojiInfo.b.yPO;
    case 8: 
      return EmojiInfo.b.yPP;
    case 9: 
      return EmojiInfo.b.yPQ;
    }
    return EmojiInfo.b.yPR;
  }
  
  /* Error */
  public final java.util.ArrayList<String> dzB()
  {
    // Byte code:
    //   0: ldc_w 744
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 746	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: getfield 527	com/tencent/mm/storage/emotion/EmojiInfo:field_attachedEmojiMD5	[B
    //   14: invokespecial 748	java/io/ByteArrayInputStream:<init>	([B)V
    //   17: astore_2
    //   18: new 750	java/io/ObjectInputStream
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 753	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore 4
    //   30: aload_2
    //   31: astore_3
    //   32: aload_1
    //   33: invokevirtual 757	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   36: checkcast 759	java/util/ArrayList
    //   39: astore 5
    //   41: aload_2
    //   42: invokevirtual 760	java/io/ByteArrayInputStream:close	()V
    //   45: aload_1
    //   46: invokevirtual 761	java/io/ObjectInputStream:close	()V
    //   49: aload 5
    //   51: astore_1
    //   52: ldc_w 744
    //   55: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_1
    //   59: areturn
    //   60: astore_2
    //   61: ldc_w 578
    //   64: new 123	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 763
    //   71: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_2
    //   75: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   78: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -42 -> 45
    //   90: astore_1
    //   91: ldc_w 578
    //   94: new 123	java/lang/StringBuilder
    //   97: dup
    //   98: ldc_w 765
    //   101: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload_1
    //   105: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   108: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 5
    //   119: astore_1
    //   120: goto -68 -> 52
    //   123: astore 5
    //   125: aconst_null
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_1
    //   130: astore 4
    //   132: aload_2
    //   133: astore_3
    //   134: ldc_w 578
    //   137: new 123	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 767
    //   144: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload 5
    //   149: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   152: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 760	java/io/ByteArrayInputStream:close	()V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 761	java/io/ObjectInputStream:close	()V
    //   177: aconst_null
    //   178: astore_1
    //   179: goto -127 -> 52
    //   182: astore_2
    //   183: ldc_w 578
    //   186: new 123	java/lang/StringBuilder
    //   189: dup
    //   190: ldc_w 763
    //   193: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: aload_2
    //   197: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: goto -40 -> 169
    //   212: astore_1
    //   213: ldc_w 578
    //   216: new 123	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 765
    //   223: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_1
    //   227: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aconst_null
    //   240: astore_1
    //   241: goto -189 -> 52
    //   244: astore_1
    //   245: aconst_null
    //   246: astore 4
    //   248: aconst_null
    //   249: astore_2
    //   250: aload_2
    //   251: ifnull +7 -> 258
    //   254: aload_2
    //   255: invokevirtual 760	java/io/ByteArrayInputStream:close	()V
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 761	java/io/ObjectInputStream:close	()V
    //   268: ldc_w 744
    //   271: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload_1
    //   275: athrow
    //   276: astore_2
    //   277: ldc_w 578
    //   280: new 123	java/lang/StringBuilder
    //   283: dup
    //   284: ldc_w 763
    //   287: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload_2
    //   291: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: goto -45 -> 258
    //   306: astore_2
    //   307: ldc_w 578
    //   310: new 123	java/lang/StringBuilder
    //   313: dup
    //   314: ldc_w 765
    //   317: invokespecial 659	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   320: aload_2
    //   321: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   324: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: goto -65 -> 268
    //   336: astore_1
    //   337: aconst_null
    //   338: astore 4
    //   340: goto -90 -> 250
    //   343: astore_1
    //   344: aload_3
    //   345: astore_2
    //   346: goto -96 -> 250
    //   349: astore 5
    //   351: aconst_null
    //   352: astore_1
    //   353: goto -224 -> 129
    //   356: astore 5
    //   358: goto -229 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	EmojiInfo
    //   26	33	1	localObject1	Object
    //   90	15	1	localException1	Exception
    //   119	60	1	localObject2	Object
    //   212	15	1	localException2	Exception
    //   240	1	1	localObject3	Object
    //   244	31	1	localObject4	Object
    //   336	1	1	localObject5	Object
    //   343	1	1	localObject6	Object
    //   352	1	1	localObject7	Object
    //   17	25	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   60	15	2	localException3	Exception
    //   128	38	2	localObject8	Object
    //   182	15	2	localException4	Exception
    //   249	6	2	localObject9	Object
    //   276	15	2	localException5	Exception
    //   306	15	2	localException6	Exception
    //   345	1	2	localObject10	Object
    //   31	314	3	localObject11	Object
    //   28	311	4	localObject12	Object
    //   39	79	5	localArrayList	java.util.ArrayList
    //   123	25	5	localException7	Exception
    //   349	1	5	localException8	Exception
    //   356	1	5	localException9	Exception
    // Exception table:
    //   from	to	target	type
    //   41	45	60	java/lang/Exception
    //   45	49	90	java/lang/Exception
    //   6	18	123	java/lang/Exception
    //   165	169	182	java/lang/Exception
    //   173	177	212	java/lang/Exception
    //   6	18	244	finally
    //   254	258	276	java/lang/Exception
    //   263	268	306	java/lang/Exception
    //   18	27	336	finally
    //   32	41	343	finally
    //   134	161	343	finally
    //   18	27	349	java/lang/Exception
    //   32	41	356	java/lang/Exception
  }
  
  public final boolean dzn()
  {
    AppMethodBeat.i(62769);
    if ((this.field_catalog == yPi) || (this.field_catalog == EmojiGroupInfo.yPe) || (this.field_catalog == yPl) || (this.field_catalog == yPk))
    {
      AppMethodBeat.o(62769);
      return true;
    }
    Object localObject = dQB();
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(62769);
      return false;
    }
    localObject = new b((String)localObject);
    if ((((b)localObject).exists()) && (((b)localObject).length() > 0L))
    {
      AppMethodBeat.o(62769);
      return true;
    }
    AppMethodBeat.o(62769);
    return false;
  }
  
  public final void dzo()
  {
    AppMethodBeat.i(62770);
    if ((this.field_catalog == yPi) || (this.field_catalog == yPl) || (this.field_catalog == yPk))
    {
      AppMethodBeat.o(62770);
      return;
    }
    Object localObject = dQB();
    if (!bo.isNullOrNil((String)localObject))
    {
      localObject = new b((String)localObject);
      if (((b)localObject).exists()) {
        ((b)localObject).delete();
      }
    }
    AppMethodBeat.o(62770);
  }
  
  public final boolean dzp()
  {
    AppMethodBeat.i(62771);
    if ((this.field_catalog == yPi) || (this.field_catalog == yPl) || (this.field_catalog == yPk))
    {
      AppMethodBeat.o(62771);
      return true;
    }
    String str = dQB();
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(62771);
      return false;
    }
    boolean bool = new b(str).exists();
    AppMethodBeat.o(62771);
    return bool;
  }
  
  public final boolean dzq()
  {
    return (this.field_catalog == yPi) || (this.field_catalog == yPl) || (this.field_catalog == yPk);
  }
  
  public final boolean dzr()
  {
    AppMethodBeat.i(62776);
    boolean bool = this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
    AppMethodBeat.o(62776);
    return bool;
  }
  
  public final boolean dzs()
  {
    AppMethodBeat.i(62777);
    if ((bo.isNullOrNil(this.field_app_id)) && (!bo.isNullOrNil(this.field_groupId)) && (!this.field_groupId.equals(String.valueOf(EmojiGroupInfo.yPe))) && (!this.field_groupId.equals(String.valueOf(EmojiGroupInfo.yPd))) && (!this.field_groupId.equals(String.valueOf(EmojiGroupInfo.yPf))) && (!this.field_groupId.equals(String.valueOf(yPg))) && (!this.field_groupId.equals("capture")))
    {
      AppMethodBeat.o(62777);
      return true;
    }
    AppMethodBeat.o(62777);
    return false;
  }
  
  public final boolean dzt()
  {
    AppMethodBeat.i(62778);
    if (!bo.isNullOrNil(this.field_wxamMd5))
    {
      AppMethodBeat.o(62778);
      return true;
    }
    AppMethodBeat.o(62778);
    return false;
  }
  
  public final String dzu()
  {
    if (this.field_svrid == null) {
      return "";
    }
    return this.field_svrid;
  }
  
  public final int dzv()
  {
    return this.field_reserved4;
  }
  
  public final void dzw()
  {
    this.field_temp = 1;
  }
  
  public final EmojiInfo.a dzx()
  {
    switch (this.field_captureStatus)
    {
    default: 
      return EmojiInfo.a.yPB;
    case 0: 
      return EmojiInfo.a.yPB;
    case 1: 
      return EmojiInfo.a.yPC;
    case 2: 
      return EmojiInfo.a.yPD;
    case 3: 
      return EmojiInfo.a.yPE;
    }
    return EmojiInfo.a.yPF;
  }
  
  public final int dzy()
  {
    return this.field_captureUploadCounter;
  }
  
  public final void dzz()
  {
    this.field_captureUploadCounter += 1;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(62787);
    boolean bool = cC(paramObject);
    AppMethodBeat.o(62787);
    return bool;
  }
  
  public final String getContent()
  {
    if (this.field_content == null) {
      return "";
    }
    return this.field_content;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public final int getGroup()
  {
    return this.field_catalog;
  }
  
  public final String getName()
  {
    if (this.field_name == null) {
      return "";
    }
    return this.field_name;
  }
  
  public final int getSize()
  {
    return this.field_size;
  }
  
  public final int getState()
  {
    return this.field_state;
  }
  
  public final Bitmap hC(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(62773);
      paramContext = hD(paramContext);
      AppMethodBeat.o(62773);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public final Bitmap hD(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc_w 856
    //   8: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: bipush 120
    //   14: invokestatic 862	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   17: pop
    //   18: aload_0
    //   19: getfield 428	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   22: getstatic 60	com/tencent/mm/storage/emotion/EmojiInfo:yPi	I
    //   25: if_icmpeq +37 -> 62
    //   28: aload_0
    //   29: getfield 428	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   32: getstatic 775	com/tencent/mm/storage/emotion/EmojiGroupInfo:yPe	I
    //   35: if_icmpeq +27 -> 62
    //   38: aload_0
    //   39: getfield 428	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   42: getstatic 66	com/tencent/mm/storage/emotion/EmojiInfo:yPl	I
    //   45: if_icmpeq +17 -> 62
    //   48: aload_0
    //   49: getfield 428	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   52: istore_2
    //   53: getstatic 64	com/tencent/mm/storage/emotion/EmojiInfo:yPk	I
    //   56: istore_3
    //   57: iload_2
    //   58: iload_3
    //   59: if_icmpne +244 -> 303
    //   62: aload_0
    //   63: invokevirtual 864	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   66: astore 4
    //   68: aload_0
    //   69: getfield 431	com/tencent/mm/storage/emotion/EmojiInfo:field_type	I
    //   72: getstatic 76	com/tencent/mm/storage/emotion/EmojiInfo:yPo	I
    //   75: if_icmpne +19 -> 94
    //   78: aload_0
    //   79: invokevirtual 866	com/tencent/mm/storage/emotion/EmojiInfo:getContent	()Ljava/lang/String;
    //   82: invokestatic 570	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   85: ifeq +53 -> 138
    //   88: aload_0
    //   89: invokevirtual 864	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   92: astore 4
    //   94: aload_1
    //   95: aload 4
    //   97: invokestatic 868	com/tencent/mm/storage/emotion/EmojiInfo:bI	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   100: astore 4
    //   102: aload 4
    //   104: astore_1
    //   105: aload 4
    //   107: invokestatic 874	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   110: astore 5
    //   112: aload 5
    //   114: astore_1
    //   115: aload 4
    //   117: ifnull +11 -> 128
    //   120: aload 4
    //   122: invokevirtual 877	java/io/InputStream:close	()V
    //   125: aload 5
    //   127: astore_1
    //   128: ldc_w 856
    //   131: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: areturn
    //   138: aload_0
    //   139: invokevirtual 866	com/tencent/mm/storage/emotion/EmojiInfo:getContent	()Ljava/lang/String;
    //   142: astore 4
    //   144: goto -50 -> 94
    //   147: astore_1
    //   148: ldc_w 578
    //   151: ldc_w 879
    //   154: iconst_1
    //   155: anewarray 582	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_1
    //   161: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload 5
    //   170: astore_1
    //   171: goto -43 -> 128
    //   174: astore_1
    //   175: aload_0
    //   176: monitorexit
    //   177: aload_1
    //   178: athrow
    //   179: astore 5
    //   181: aconst_null
    //   182: astore 4
    //   184: aload 4
    //   186: astore_1
    //   187: ldc_w 578
    //   190: ldc_w 879
    //   193: iconst_1
    //   194: anewarray 582	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload 5
    //   201: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   204: aastore
    //   205: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload 4
    //   210: ifnull +88 -> 298
    //   213: aload 4
    //   215: invokevirtual 877	java/io/InputStream:close	()V
    //   218: aconst_null
    //   219: astore_1
    //   220: goto -92 -> 128
    //   223: astore_1
    //   224: ldc_w 578
    //   227: ldc_w 879
    //   230: iconst_1
    //   231: anewarray 582	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload_1
    //   237: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   240: aastore
    //   241: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aconst_null
    //   245: astore_1
    //   246: goto -118 -> 128
    //   249: astore_1
    //   250: aload 5
    //   252: astore 4
    //   254: aload 4
    //   256: ifnull +8 -> 264
    //   259: aload 4
    //   261: invokevirtual 877	java/io/InputStream:close	()V
    //   264: ldc_w 856
    //   267: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_1
    //   271: athrow
    //   272: astore 4
    //   274: ldc_w 578
    //   277: ldc_w 879
    //   280: iconst_1
    //   281: anewarray 582	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload 4
    //   288: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   291: aastore
    //   292: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: goto -31 -> 264
    //   298: aconst_null
    //   299: astore_1
    //   300: goto -172 -> 128
    //   303: aload_0
    //   304: invokevirtual 887	com/tencent/mm/storage/emotion/EmojiInfo:dzs	()Z
    //   307: ifeq +150 -> 457
    //   310: aload_0
    //   311: invokevirtual 702	com/tencent/mm/storage/emotion/EmojiInfo:dQB	()Ljava/lang/String;
    //   314: astore_1
    //   315: aload_1
    //   316: ifnonnull +841 -> 1157
    //   319: new 123	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   326: aload_0
    //   327: getfield 390	com/tencent/mm/storage/emotion/EmojiInfo:pIR	Ljava/lang/String;
    //   330: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: getfield 464	com/tencent/mm/storage/emotion/EmojiInfo:field_groupId	Ljava/lang/String;
    //   337: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc_w 698
    //   343: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_0
    //   347: invokevirtual 676	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   350: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc_w 889
    //   356: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: astore_1
    //   363: new 777	com/tencent/mm/vfs/b
    //   366: dup
    //   367: aload_1
    //   368: invokespecial 778	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   371: astore_1
    //   372: aload_1
    //   373: invokevirtual 781	com/tencent/mm/vfs/b:exists	()Z
    //   376: ifeq +214 -> 590
    //   379: aload_1
    //   380: invokestatic 895	com/tencent/mm/vfs/e:q	(Lcom/tencent/mm/vfs/b;)Ljava/io/InputStream;
    //   383: astore 4
    //   385: aload 4
    //   387: astore_1
    //   388: aload 4
    //   390: astore 5
    //   392: aload 4
    //   394: astore 6
    //   396: aload 4
    //   398: invokestatic 874	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   401: astore 7
    //   403: aload 7
    //   405: astore 6
    //   407: aload 4
    //   409: astore 7
    //   411: aload 6
    //   413: astore_1
    //   414: aload 7
    //   416: ifnull -288 -> 128
    //   419: aload 7
    //   421: invokevirtual 877	java/io/InputStream:close	()V
    //   424: aload 6
    //   426: astore_1
    //   427: goto -299 -> 128
    //   430: astore_1
    //   431: ldc_w 578
    //   434: ldc_w 879
    //   437: iconst_1
    //   438: anewarray 582	java/lang/Object
    //   441: dup
    //   442: iconst_0
    //   443: aload_1
    //   444: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   447: aastore
    //   448: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   451: aload 6
    //   453: astore_1
    //   454: goto -326 -> 128
    //   457: new 777	com/tencent/mm/vfs/b
    //   460: dup
    //   461: new 123	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   468: aload_0
    //   469: getfield 390	com/tencent/mm/storage/emotion/EmojiInfo:pIR	Ljava/lang/String;
    //   472: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload_0
    //   476: invokevirtual 676	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   479: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: ldc_w 897
    //   485: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokespecial 778	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   494: astore_1
    //   495: goto -123 -> 372
    //   498: astore 7
    //   500: aconst_null
    //   501: astore 4
    //   503: aconst_null
    //   504: astore 5
    //   506: aload 4
    //   508: astore_1
    //   509: ldc_w 578
    //   512: ldc_w 879
    //   515: iconst_1
    //   516: anewarray 582	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: aload 7
    //   523: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   526: aastore
    //   527: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   530: aload 4
    //   532: astore_1
    //   533: ldc_w 578
    //   536: aload 7
    //   538: invokevirtual 898	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   541: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: aload 5
    //   546: astore_1
    //   547: aload 4
    //   549: ifnull -421 -> 128
    //   552: aload 4
    //   554: invokevirtual 877	java/io/InputStream:close	()V
    //   557: aload 5
    //   559: astore_1
    //   560: goto -432 -> 128
    //   563: astore_1
    //   564: ldc_w 578
    //   567: ldc_w 879
    //   570: iconst_1
    //   571: anewarray 582	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: aload_1
    //   577: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   580: aastore
    //   581: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   584: aload 5
    //   586: astore_1
    //   587: goto -459 -> 128
    //   590: aload_0
    //   591: invokevirtual 887	com/tencent/mm/storage/emotion/EmojiInfo:dzs	()Z
    //   594: ifeq +256 -> 850
    //   597: getstatic 903	android/os/Build$VERSION:SDK_INT	I
    //   600: bipush 19
    //   602: if_icmpge +546 -> 1148
    //   605: new 123	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   612: aload_0
    //   613: getfield 390	com/tencent/mm/storage/emotion/EmojiInfo:pIR	Ljava/lang/String;
    //   616: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload_0
    //   620: getfield 464	com/tencent/mm/storage/emotion/EmojiInfo:field_groupId	Ljava/lang/String;
    //   623: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: ldc_w 698
    //   629: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: aload_0
    //   633: invokevirtual 676	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   636: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 907	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   645: astore 4
    //   647: aload 4
    //   649: astore_1
    //   650: aload 4
    //   652: astore 5
    //   654: aload 4
    //   656: astore 6
    //   658: aload 4
    //   660: invokestatic 874	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   663: astore 7
    //   665: aload 7
    //   667: astore 5
    //   669: aload 4
    //   671: astore_1
    //   672: aload_0
    //   673: invokevirtual 887	com/tencent/mm/storage/emotion/EmojiInfo:dzs	()Z
    //   676: ifeq +228 -> 904
    //   679: aload 4
    //   681: astore_1
    //   682: ldc_w 578
    //   685: ldc_w 909
    //   688: invokestatic 911	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: aload 4
    //   693: astore 7
    //   695: aload 5
    //   697: astore 6
    //   699: aload 4
    //   701: astore_1
    //   702: new 777	com/tencent/mm/vfs/b
    //   705: dup
    //   706: new 123	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   713: aload_0
    //   714: getfield 390	com/tencent/mm/storage/emotion/EmojiInfo:pIR	Ljava/lang/String;
    //   717: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload_0
    //   721: getfield 464	com/tencent/mm/storage/emotion/EmojiInfo:field_groupId	Ljava/lang/String;
    //   724: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: ldc_w 698
    //   730: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload_0
    //   734: invokevirtual 676	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   737: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: ldc_w 704
    //   743: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokespecial 778	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   752: invokevirtual 781	com/tencent/mm/vfs/b:exists	()Z
    //   755: ifne -344 -> 411
    //   758: aload 4
    //   760: astore 7
    //   762: aload 5
    //   764: astore 6
    //   766: aload 4
    //   768: astore_1
    //   769: getstatic 903	android/os/Build$VERSION:SDK_INT	I
    //   772: bipush 19
    //   774: if_icmpge -363 -> 411
    //   777: aload 4
    //   779: astore_1
    //   780: aload 5
    //   782: bipush 100
    //   784: getstatic 917	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   787: new 123	java/lang/StringBuilder
    //   790: dup
    //   791: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   794: aload_0
    //   795: getfield 390	com/tencent/mm/storage/emotion/EmojiInfo:pIR	Ljava/lang/String;
    //   798: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload_0
    //   802: getfield 464	com/tencent/mm/storage/emotion/EmojiInfo:field_groupId	Ljava/lang/String;
    //   805: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc_w 698
    //   811: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: aload_0
    //   815: invokevirtual 676	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   818: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: ldc_w 704
    //   824: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: iconst_0
    //   831: invokestatic 920	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   834: aload 4
    //   836: astore 7
    //   838: aload 5
    //   840: astore 6
    //   842: goto -431 -> 411
    //   845: astore 7
    //   847: goto -341 -> 506
    //   850: new 123	java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   857: aload_0
    //   858: getfield 390	com/tencent/mm/storage/emotion/EmojiInfo:pIR	Ljava/lang/String;
    //   861: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: aload_0
    //   865: invokevirtual 676	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   868: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   874: invokestatic 907	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   877: astore 4
    //   879: aload 4
    //   881: astore_1
    //   882: aload 4
    //   884: astore 5
    //   886: aload 4
    //   888: astore 6
    //   890: aload 4
    //   892: invokestatic 874	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   895: astore 7
    //   897: aload 7
    //   899: astore 5
    //   901: goto -232 -> 669
    //   904: aload 4
    //   906: astore_1
    //   907: aload 5
    //   909: bipush 100
    //   911: getstatic 917	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   914: new 123	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   921: aload_0
    //   922: getfield 390	com/tencent/mm/storage/emotion/EmojiInfo:pIR	Ljava/lang/String;
    //   925: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: aload_0
    //   929: invokevirtual 676	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   932: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: ldc_w 897
    //   938: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: iconst_0
    //   945: invokestatic 920	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   948: aload 4
    //   950: astore 7
    //   952: aload 5
    //   954: astore 6
    //   956: goto -545 -> 411
    //   959: astore 6
    //   961: aload 4
    //   963: astore_1
    //   964: ldc_w 578
    //   967: ldc_w 879
    //   970: iconst_1
    //   971: anewarray 582	java/lang/Object
    //   974: dup
    //   975: iconst_0
    //   976: aload 6
    //   978: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   981: aastore
    //   982: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   985: aload 4
    //   987: astore_1
    //   988: ldc_w 578
    //   991: aload 6
    //   993: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   996: invokestatic 663	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   999: aload 5
    //   1001: astore_1
    //   1002: aload 4
    //   1004: ifnull -876 -> 128
    //   1007: aload 4
    //   1009: invokevirtual 877	java/io/InputStream:close	()V
    //   1012: aload 5
    //   1014: astore_1
    //   1015: goto -887 -> 128
    //   1018: astore_1
    //   1019: ldc_w 578
    //   1022: ldc_w 879
    //   1025: iconst_1
    //   1026: anewarray 582	java/lang/Object
    //   1029: dup
    //   1030: iconst_0
    //   1031: aload_1
    //   1032: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1035: aastore
    //   1036: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1039: aload 5
    //   1041: astore_1
    //   1042: goto -914 -> 128
    //   1045: astore 4
    //   1047: aconst_null
    //   1048: astore_1
    //   1049: aload_1
    //   1050: ifnull +7 -> 1057
    //   1053: aload_1
    //   1054: invokevirtual 877	java/io/InputStream:close	()V
    //   1057: ldc_w 856
    //   1060: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1063: aload 4
    //   1065: athrow
    //   1066: astore_1
    //   1067: ldc_w 578
    //   1070: ldc_w 879
    //   1073: iconst_1
    //   1074: anewarray 582	java/lang/Object
    //   1077: dup
    //   1078: iconst_0
    //   1079: aload_1
    //   1080: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1083: aastore
    //   1084: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1087: goto -30 -> 1057
    //   1090: astore 4
    //   1092: goto -43 -> 1049
    //   1095: astore 6
    //   1097: aconst_null
    //   1098: astore 4
    //   1100: aconst_null
    //   1101: astore 5
    //   1103: goto -142 -> 961
    //   1106: astore 6
    //   1108: aconst_null
    //   1109: astore_1
    //   1110: aload 5
    //   1112: astore 4
    //   1114: aload_1
    //   1115: astore 5
    //   1117: goto -156 -> 961
    //   1120: astore 7
    //   1122: aconst_null
    //   1123: astore 5
    //   1125: aload 6
    //   1127: astore 4
    //   1129: goto -623 -> 506
    //   1132: astore 5
    //   1134: aload_1
    //   1135: astore 4
    //   1137: aload 5
    //   1139: astore_1
    //   1140: goto -886 -> 254
    //   1143: astore 5
    //   1145: goto -961 -> 184
    //   1148: aconst_null
    //   1149: astore 4
    //   1151: aconst_null
    //   1152: astore 5
    //   1154: goto -485 -> 669
    //   1157: goto -794 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1160	0	this	EmojiInfo
    //   0	1160	1	paramContext	Context
    //   52	8	2	i	int
    //   56	4	3	j	int
    //   66	194	4	localObject1	Object
    //   272	15	4	localIOException	java.io.IOException
    //   383	625	4	localInputStream	InputStream
    //   1045	19	4	localObject2	Object
    //   1090	1	4	localObject3	Object
    //   1098	52	4	localObject4	Object
    //   1	168	5	localBitmap	Bitmap
    //   179	72	5	localException1	Exception
    //   390	734	5	localObject5	Object
    //   1132	6	5	localObject6	Object
    //   1143	1	5	localException2	Exception
    //   1152	1	5	localObject7	Object
    //   394	561	6	localObject8	Object
    //   959	33	6	localException3	Exception
    //   1095	1	6	localException4	Exception
    //   1106	20	6	localException5	Exception
    //   401	19	7	localObject9	Object
    //   498	39	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   663	174	7	localObject10	Object
    //   845	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   895	56	7	localObject11	Object
    //   1120	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   120	125	147	java/io/IOException
    //   5	57	174	finally
    //   120	125	174	finally
    //   128	134	174	finally
    //   148	168	174	finally
    //   213	218	174	finally
    //   224	244	174	finally
    //   259	264	174	finally
    //   264	272	174	finally
    //   274	295	174	finally
    //   419	424	174	finally
    //   431	451	174	finally
    //   552	557	174	finally
    //   564	584	174	finally
    //   1007	1012	174	finally
    //   1019	1039	174	finally
    //   1053	1057	174	finally
    //   1057	1066	174	finally
    //   1067	1087	174	finally
    //   62	68	179	java/lang/Exception
    //   68	94	179	java/lang/Exception
    //   94	102	179	java/lang/Exception
    //   138	144	179	java/lang/Exception
    //   213	218	223	java/io/IOException
    //   62	68	249	finally
    //   68	94	249	finally
    //   94	102	249	finally
    //   138	144	249	finally
    //   259	264	272	java/io/IOException
    //   419	424	430	java/io/IOException
    //   303	315	498	java/io/FileNotFoundException
    //   319	363	498	java/io/FileNotFoundException
    //   363	372	498	java/io/FileNotFoundException
    //   372	385	498	java/io/FileNotFoundException
    //   457	495	498	java/io/FileNotFoundException
    //   590	647	498	java/io/FileNotFoundException
    //   850	879	498	java/io/FileNotFoundException
    //   552	557	563	java/io/IOException
    //   672	679	845	java/io/FileNotFoundException
    //   682	691	845	java/io/FileNotFoundException
    //   702	758	845	java/io/FileNotFoundException
    //   769	777	845	java/io/FileNotFoundException
    //   780	834	845	java/io/FileNotFoundException
    //   907	948	845	java/io/FileNotFoundException
    //   672	679	959	java/lang/Exception
    //   682	691	959	java/lang/Exception
    //   702	758	959	java/lang/Exception
    //   769	777	959	java/lang/Exception
    //   780	834	959	java/lang/Exception
    //   907	948	959	java/lang/Exception
    //   1007	1012	1018	java/io/IOException
    //   303	315	1045	finally
    //   319	363	1045	finally
    //   363	372	1045	finally
    //   372	385	1045	finally
    //   457	495	1045	finally
    //   590	647	1045	finally
    //   850	879	1045	finally
    //   1053	1057	1066	java/io/IOException
    //   396	403	1090	finally
    //   509	530	1090	finally
    //   533	544	1090	finally
    //   658	665	1090	finally
    //   672	679	1090	finally
    //   682	691	1090	finally
    //   702	758	1090	finally
    //   769	777	1090	finally
    //   780	834	1090	finally
    //   890	897	1090	finally
    //   907	948	1090	finally
    //   964	985	1090	finally
    //   988	999	1090	finally
    //   303	315	1095	java/lang/Exception
    //   319	363	1095	java/lang/Exception
    //   363	372	1095	java/lang/Exception
    //   372	385	1095	java/lang/Exception
    //   457	495	1095	java/lang/Exception
    //   590	647	1095	java/lang/Exception
    //   850	879	1095	java/lang/Exception
    //   396	403	1106	java/lang/Exception
    //   658	665	1106	java/lang/Exception
    //   890	897	1106	java/lang/Exception
    //   396	403	1120	java/io/FileNotFoundException
    //   658	665	1120	java/io/FileNotFoundException
    //   890	897	1120	java/io/FileNotFoundException
    //   105	112	1132	finally
    //   187	208	1132	finally
    //   105	112	1143	java/lang/Exception
  }
  
  /* Error */
  public final byte[] ho(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 923
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: iflt +7 -> 14
    //   10: iload_2
    //   11: ifge +11 -> 22
    //   14: ldc_w 923
    //   17: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: aload_0
    //   23: getfield 428	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   26: getstatic 60	com/tencent/mm/storage/emotion/EmojiInfo:yPi	I
    //   29: if_icmpeq +23 -> 52
    //   32: aload_0
    //   33: getfield 428	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   36: getstatic 66	com/tencent/mm/storage/emotion/EmojiInfo:yPl	I
    //   39: if_icmpeq +13 -> 52
    //   42: aload_0
    //   43: getfield 428	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   46: getstatic 64	com/tencent/mm/storage/emotion/EmojiInfo:yPk	I
    //   49: if_icmpne +157 -> 206
    //   52: ldc_w 578
    //   55: ldc_w 925
    //   58: iconst_1
    //   59: anewarray 582	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: invokevirtual 864	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 588	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: invokestatic 931	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   75: aload_0
    //   76: invokevirtual 864	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   79: invokestatic 868	com/tencent/mm/storage/emotion/EmojiInfo:bI	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   82: astore 6
    //   84: iload_1
    //   85: i2l
    //   86: lstore_3
    //   87: aload 6
    //   89: astore 5
    //   91: aload 6
    //   93: lload_3
    //   94: invokevirtual 935	java/io/InputStream:skip	(J)J
    //   97: pop2
    //   98: aload 6
    //   100: astore 5
    //   102: iload_2
    //   103: newarray byte
    //   105: astore 7
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: aload 7
    //   115: iconst_0
    //   116: iload_2
    //   117: invokevirtual 939	java/io/InputStream:read	([BII)I
    //   120: pop
    //   121: aload 6
    //   123: ifnull +8 -> 131
    //   126: aload 6
    //   128: invokevirtual 877	java/io/InputStream:close	()V
    //   131: ldc_w 923
    //   134: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload 7
    //   139: areturn
    //   140: astore 5
    //   142: ldc_w 578
    //   145: ldc_w 879
    //   148: iconst_1
    //   149: anewarray 582	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 5
    //   156: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: goto -32 -> 131
    //   166: astore 7
    //   168: aconst_null
    //   169: astore 6
    //   171: aload 6
    //   173: astore 5
    //   175: ldc_w 578
    //   178: ldc_w 879
    //   181: iconst_1
    //   182: anewarray 582	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload 7
    //   189: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload 6
    //   198: ifnull +8 -> 206
    //   201: aload 6
    //   203: invokevirtual 877	java/io/InputStream:close	()V
    //   206: aload_0
    //   207: invokevirtual 702	com/tencent/mm/storage/emotion/EmojiInfo:dQB	()Ljava/lang/String;
    //   210: aload_0
    //   211: getfield 437	com/tencent/mm/storage/emotion/EmojiInfo:field_start	I
    //   214: iload_2
    //   215: invokestatic 942	com/tencent/mm/vfs/e:i	(Ljava/lang/String;II)[B
    //   218: astore 5
    //   220: ldc_w 923
    //   223: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload 5
    //   228: areturn
    //   229: astore 5
    //   231: ldc_w 578
    //   234: ldc_w 879
    //   237: iconst_1
    //   238: anewarray 582	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: aload 5
    //   245: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   248: aastore
    //   249: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: goto -46 -> 206
    //   255: astore 6
    //   257: aconst_null
    //   258: astore 5
    //   260: aload 5
    //   262: ifnull +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 877	java/io/InputStream:close	()V
    //   270: ldc_w 923
    //   273: invokestatic 352	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload 6
    //   278: athrow
    //   279: astore 5
    //   281: ldc_w 578
    //   284: ldc_w 879
    //   287: iconst_1
    //   288: anewarray 582	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: aload 5
    //   295: invokestatic 883	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   298: aastore
    //   299: invokestatic 885	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: goto -32 -> 270
    //   305: astore 6
    //   307: goto -47 -> 260
    //   310: astore 7
    //   312: goto -141 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	EmojiInfo
    //   0	315	1	paramInt1	int
    //   0	315	2	paramInt2	int
    //   86	8	3	l	long
    //   89	21	5	localInputStream1	InputStream
    //   140	15	5	localIOException1	java.io.IOException
    //   173	54	5	localObject1	Object
    //   229	15	5	localIOException2	java.io.IOException
    //   258	8	5	localObject2	Object
    //   279	15	5	localIOException3	java.io.IOException
    //   82	120	6	localInputStream2	InputStream
    //   255	22	6	localObject3	Object
    //   305	1	6	localObject4	Object
    //   105	33	7	arrayOfByte	byte[]
    //   166	22	7	localIOException4	java.io.IOException
    //   310	1	7	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   126	131	140	java/io/IOException
    //   52	84	166	java/io/IOException
    //   201	206	229	java/io/IOException
    //   52	84	255	finally
    //   265	270	279	java/io/IOException
    //   91	98	305	finally
    //   102	107	305	finally
    //   111	121	305	finally
    //   175	196	305	finally
    //   91	98	310	java/io/IOException
    //   102	107	310	java/io/IOException
    //   111	121	310	java/io/IOException
  }
  
  public final boolean isGif()
  {
    return (this.field_type == yPo) || (this.field_type == yPq);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(62767);
    this.field_md5 = "";
    this.field_svrid = "";
    this.field_catalog = yPi;
    this.field_type = yPn;
    this.field_size = 0;
    this.field_start = 0;
    this.field_state = yPs;
    this.field_name = "";
    this.field_content = "";
    this.field_reserved1 = "";
    this.field_reserved2 = "";
    this.field_reserved3 = 0;
    this.field_reserved4 = 0;
    this.field_app_id = "";
    this.field_temp = 0;
    this.field_captureStatus = EmojiInfo.a.yPB.ordinal();
    this.field_captureUploadErrCode = EmojiInfo.b.yPH.ordinal();
    this.field_captureUploadCounter = 0;
    this.field_imitateMd5 = "";
    this.field_attachedEmojiMD5 = new byte[0];
    AppMethodBeat.o(62767);
  }
  
  public final void setSize(int paramInt)
  {
    this.field_size = paramInt;
  }
  
  public final void setState(int paramInt)
  {
    this.field_state = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(62789);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("field_md5:").append(this.field_md5).append("\n");
    ((StringBuilder)localObject).append("field_svrid:").append(this.field_svrid).append("\n");
    ((StringBuilder)localObject).append("field_catalog:").append(this.field_catalog).append("\n");
    ((StringBuilder)localObject).append("field_type:").append(this.field_type).append("\n");
    ((StringBuilder)localObject).append("field_size:").append(this.field_size).append("\n");
    ((StringBuilder)localObject).append("field_start:").append(this.field_start).append("\n");
    ((StringBuilder)localObject).append("field_state:").append(this.field_state).append("\n");
    ((StringBuilder)localObject).append("field_name:").append(this.field_name).append("\n");
    ((StringBuilder)localObject).append("field_content:").append(this.field_content).append("\n");
    ((StringBuilder)localObject).append("field_reserved1:").append(this.field_reserved1).append("\n");
    ((StringBuilder)localObject).append("field_reserved2:").append(this.field_reserved2).append("\n");
    ((StringBuilder)localObject).append("field_reserved3:").append(this.field_reserved3).append("\n");
    ((StringBuilder)localObject).append("field_reserved4:").append(this.field_reserved4).append("\n");
    ((StringBuilder)localObject).append("field_app_id:").append(this.field_app_id).append("\n");
    ((StringBuilder)localObject).append("field_groupId:").append(this.field_groupId).append("\n");
    ((StringBuilder)localObject).append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
    ((StringBuilder)localObject).append("field_framesInfo:").append(this.field_framesInfo).append("\n");
    ((StringBuilder)localObject).append("field_idx:").append(this.field_idx).append("\n");
    ((StringBuilder)localObject).append("field_temp:").append(this.field_temp).append("\n");
    ((StringBuilder)localObject).append("field_source:").append(this.field_source).append("\n");
    ((StringBuilder)localObject).append("field_needupload:").append(this.field_needupload).append("\n");
    ((StringBuilder)localObject).append("field_designerID:").append(this.field_designerID).append("\n");
    ((StringBuilder)localObject).append("field_thumbUrl:").append(this.field_thumbUrl).append("\n");
    ((StringBuilder)localObject).append("field_captureStatus:").append(this.field_captureStatus).append("\n");
    ((StringBuilder)localObject).append("field_captureUploadErrCode").append(this.field_captureUploadErrCode).append("\n");
    ((StringBuilder)localObject).append("field_captureUploadCounter").append(this.field_captureUploadCounter).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(62789);
    return localObject;
  }
  
  public final boolean vY()
  {
    return (this.field_catalog == yPl) || (this.field_catalog == yPk);
  }
  
  public final void wW(String paramString)
  {
    this.field_md5 = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(62790);
    paramParcel.writeString(this.pIR);
    paramParcel.writeString(this.field_md5);
    paramParcel.writeString(this.field_svrid);
    paramParcel.writeInt(this.field_catalog);
    paramParcel.writeInt(this.field_type);
    paramParcel.writeInt(this.field_size);
    paramParcel.writeInt(this.field_start);
    paramParcel.writeInt(this.field_state);
    paramParcel.writeString(this.field_name);
    paramParcel.writeString(this.field_content);
    paramParcel.writeString(this.field_reserved1);
    paramParcel.writeString(this.field_reserved2);
    paramParcel.writeInt(this.field_reserved3);
    paramParcel.writeInt(this.field_reserved4);
    paramParcel.writeString(this.field_app_id);
    paramParcel.writeString(this.field_groupId);
    paramParcel.writeLong(this.field_lastUseTime);
    paramParcel.writeString(this.field_framesInfo);
    paramParcel.writeInt(this.field_idx);
    paramParcel.writeInt(this.field_temp);
    paramParcel.writeInt(this.field_source);
    paramParcel.writeInt(this.field_needupload);
    paramParcel.writeString(this.field_designerID);
    paramParcel.writeString(this.field_thumbUrl);
    paramParcel.writeString(this.field_cdnUrl);
    paramParcel.writeString(this.field_encrypturl);
    paramParcel.writeString(this.field_aeskey);
    paramParcel.writeInt(this.field_width);
    paramParcel.writeInt(this.field_height);
    paramParcel.writeString(this.field_activityid);
    paramParcel.writeLong(this.systemRowid);
    paramParcel.writeString(this.field_wxamMd5);
    paramParcel.writeString(this.field_attachedText);
    paramParcel.writeInt(this.field_captureStatus);
    if ((this.field_attachedEmojiMD5 != null) && (this.field_attachedEmojiMD5.length > 0))
    {
      paramParcel.writeInt(this.field_attachedEmojiMD5.length);
      paramParcel.writeByteArray(this.field_attachedEmojiMD5);
    }
    for (;;)
    {
      paramParcel.writeString(this.field_imitateMd5);
      paramParcel.writeInt(this.field_captureUploadErrCode);
      paramParcel.writeInt(this.field_captureUploadCounter);
      paramParcel.writeLong(this.field_captureEnterTime);
      paramParcel.writeString(this.field_lensId);
      paramParcel.writeString(this.field_attachTextColor);
      paramParcel.writeInt(this.field_captureScene);
      paramParcel.writeString(this.field_externMd5);
      AppMethodBeat.o(62790);
      return;
      paramParcel.writeInt(0);
    }
  }
  
  public final Bitmap y(Context paramContext, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(62774);
        if ((this.field_catalog == EmojiGroupInfo.yPe) || (this.field_catalog == yPl) || (this.field_catalog == yPk))
        {
          localObject = getName();
          if (!bo.isNullOrNil((String)localObject))
          {
            if (((String)localObject).startsWith("jsb"))
            {
              localObject = "jsb";
              paramInt = paramContext.getResources().getIdentifier((String)localObject, "drawable", ah.getPackageName());
              paramContext = com.tencent.mm.sdk.platformtools.d.u(paramContext.getResources().getDrawable(paramInt));
              ab.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(this.field_catalog), Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
              AppMethodBeat.o(62774);
              return paramContext;
            }
            if (((String)localObject).startsWith("dice"))
            {
              localObject = "dice";
              continue;
            }
            localObject = ((String)localObject).replaceAll(".png", "");
            continue;
          }
          ab.i("MicroMsg.emoji.EmojiInfo", "name is null");
          ab.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", new Object[] { this });
          paramContext = null;
          AppMethodBeat.o(62774);
          continue;
        }
        if (this.field_catalog != EmojiGroupInfo.yPd) {
          break label400;
        }
      }
      finally {}
      localObject = getName();
      if (!bo.isNullOrNil((String)localObject)) {
        if (bo.isNullOrNil(getContent()))
        {
          localObject = getName();
          label268:
          localObject = ((String)localObject).replaceAll(".png", "");
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] drawable name:%s", new Object[] { localObject });
        paramInt = paramContext.getResources().getIdentifier((String)localObject, "drawable", ah.getPackageName());
        paramContext = com.tencent.mm.sdk.platformtools.d.u(paramContext.getResources().getDrawable(paramInt));
        ab.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(this.field_catalog), Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
        AppMethodBeat.o(62774);
        break;
        localObject = getContent();
        break label268;
        ab.i("MicroMsg.emoji.EmojiInfo", "name is null");
      }
      label400:
      paramContext = dQB() + "_cover";
      boolean bool = com.tencent.mm.vfs.e.cN(paramContext);
      ab.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] thumbPath:%s isExist:%s", new Object[] { paramContext, Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      paramContext = dQB();
      bool = com.tencent.mm.vfs.e.cN(paramContext);
      if (bool)
      {
        paramContext = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().l(this);
        if (paramContext == null)
        {
          ab.e("MicroMsg.emoji.EmojiInfo", "bytes is null!");
          paramContext = null;
          AppMethodBeat.o(62774);
        }
        else
        {
          ab.i("MicroMsg.emoji.EmojiInfo", "bytes size:%s", new Object[] { Integer.valueOf(paramContext.length) });
          if (r.bX(paramContext)) {}
          for (paramContext = i.aX(paramContext);; paramContext = com.tencent.mm.sdk.platformtools.d.decodeByteArray(paramContext, paramInt, paramInt))
          {
            if (paramContext != null) {
              ab.i("MicroMsg.emoji.EmojiInfo", "emoji:%s width:%s height:%s", new Object[] { this, Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
            }
            AppMethodBeat.o(62774);
            break;
          }
        }
      }
      else
      {
        ab.w("MicroMsg.emoji.EmojiInfo", "[addEmoji] Path:%s isExist:%s", new Object[] { paramContext, Boolean.valueOf(bool) });
      }
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramContext, (BitmapFactory.Options)localObject);
    label697:
    int j;
    if ((((BitmapFactory.Options)localObject).outHeight < paramInt) && (((BitmapFactory.Options)localObject).outWidth < paramInt))
    {
      paramContext = com.tencent.mm.sdk.platformtools.d.az(paramContext, ((BitmapFactory.Options)localObject).outHeight, ((BitmapFactory.Options)localObject).outWidth);
      j = this.field_catalog;
      if (paramContext != null) {
        break label767;
      }
      paramInt = 0;
      label709:
      if (paramContext != null) {
        break label775;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(62774);
      break;
      paramContext = com.tencent.mm.sdk.platformtools.d.az(paramContext, paramInt, paramInt);
      break label697;
      label767:
      paramInt = paramContext.getWidth();
      break label709;
      label775:
      i = paramContext.getHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.EmojiInfo
 * JD-Core Version:    0.7.0.1
 */