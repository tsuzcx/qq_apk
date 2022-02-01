package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.p;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.g.c.bg;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.t;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;

public class EmojiInfo
  extends bg
  implements Parcelable, p
{
  public static final Parcelable.Creator<EmojiInfo> CREATOR;
  public static int LBM;
  public static int LBQ;
  public static String LBR;
  public static int LBS;
  public static int LBT;
  public static int LBU;
  public static int LBV;
  public static int LBW;
  public static int LBX;
  public static int LBY;
  public static int LBZ;
  public static int LCa;
  public static int LCb;
  public static int LCc;
  public static int LCd;
  public static int LCe;
  public static int LCf;
  public static int LCg;
  public static int LCh;
  public static int LCi;
  public static int LCj;
  public static int LCk;
  public static int LCl;
  public static int TYPE_TEXT;
  protected static c.a info;
  public String LCm;
  public int LCn;
  public int LCo;
  public String talker;
  private final String uLk;
  
  static
  {
    AppMethodBeat.i(105048);
    LBR = ".gif";
    LBS = 17;
    LBT = 32;
    LBU = 49;
    LBV = 50;
    LBQ = 65;
    LBW = 81;
    LBM = -1;
    LBX = 1;
    LBY = 2;
    LBZ = 3;
    TYPE_TEXT = 4;
    LCa = 10;
    LCb = 11;
    LCc = 0;
    LCd = 1;
    LCe = 3;
    LCf = 4;
    LCg = 8;
    LCh = 0;
    LCi = 1;
    LCj = 0;
    LCk = 1;
    LCl = 1;
    c.a locala = new c.a();
    locala.EYt = new Field[44];
    locala.columns = new String[45];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "md5";
    locala.EYv.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.EYu = "md5";
    locala.columns[1] = "svrid";
    locala.EYv.put("svrid", "TEXT");
    localStringBuilder.append(" svrid TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "catalog";
    locala.EYv.put("catalog", "INTEGER");
    localStringBuilder.append(" catalog INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "type";
    locala.EYv.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "size";
    locala.EYv.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "start";
    locala.EYv.put("start", "INTEGER");
    localStringBuilder.append(" start INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "state";
    locala.EYv.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "name";
    locala.EYv.put("name", "TEXT");
    localStringBuilder.append(" name TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "content";
    locala.EYv.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "reserved1";
    locala.EYv.put("reserved1", "TEXT");
    localStringBuilder.append(" reserved1 TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "reserved2";
    locala.EYv.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "reserved3";
    locala.EYv.put("reserved3", "INTEGER");
    localStringBuilder.append(" reserved3 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "reserved4";
    locala.EYv.put("reserved4", "INTEGER");
    localStringBuilder.append(" reserved4 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "app_id";
    locala.EYv.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "groupId";
    locala.EYv.put("groupId", "TEXT default '' ");
    localStringBuilder.append(" groupId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "lastUseTime";
    locala.EYv.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localStringBuilder.append(", ");
    locala.columns[16] = "framesInfo";
    locala.EYv.put("framesInfo", "TEXT default '' ");
    localStringBuilder.append(" framesInfo TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "idx";
    locala.EYv.put("idx", "INTEGER default '0' ");
    localStringBuilder.append(" idx INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "temp";
    locala.EYv.put("temp", "INTEGER default '0' ");
    localStringBuilder.append(" temp INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "source";
    locala.EYv.put("source", "INTEGER default '0' ");
    localStringBuilder.append(" source INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "needupload";
    locala.EYv.put("needupload", "INTEGER default '0' ");
    localStringBuilder.append(" needupload INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "designerID";
    locala.EYv.put("designerID", "TEXT");
    localStringBuilder.append(" designerID TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "thumbUrl";
    locala.EYv.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "cdnUrl";
    locala.EYv.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "encrypturl";
    locala.EYv.put("encrypturl", "TEXT");
    localStringBuilder.append(" encrypturl TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "aeskey";
    locala.EYv.put("aeskey", "TEXT");
    localStringBuilder.append(" aeskey TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "width";
    locala.EYv.put("width", "INTEGER default '0' ");
    localStringBuilder.append(" width INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[27] = "height";
    locala.EYv.put("height", "INTEGER default '0' ");
    localStringBuilder.append(" height INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[28] = "externUrl";
    locala.EYv.put("externUrl", "TEXT");
    localStringBuilder.append(" externUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "externMd5";
    locala.EYv.put("externMd5", "TEXT");
    localStringBuilder.append(" externMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "activityid";
    locala.EYv.put("activityid", "TEXT");
    localStringBuilder.append(" activityid TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "tpurl";
    locala.EYv.put("tpurl", "TEXT");
    localStringBuilder.append(" tpurl TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "tpauthkey";
    locala.EYv.put("tpauthkey", "TEXT");
    localStringBuilder.append(" tpauthkey TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "wxamMd5";
    locala.EYv.put("wxamMd5", "TEXT");
    localStringBuilder.append(" wxamMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "attachedText";
    locala.EYv.put("attachedText", "TEXT");
    localStringBuilder.append(" attachedText TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "captureStatus";
    locala.EYv.put("captureStatus", "INTEGER default '0' ");
    localStringBuilder.append(" captureStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[36] = "attachedEmojiMD5";
    locala.EYv.put("attachedEmojiMD5", "BLOB default '' ");
    localStringBuilder.append(" attachedEmojiMD5 BLOB default '' ");
    localStringBuilder.append(", ");
    locala.columns[37] = "imitateMd5";
    locala.EYv.put("imitateMd5", "TEXT");
    localStringBuilder.append(" imitateMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[38] = "captureUploadErrCode";
    locala.EYv.put("captureUploadErrCode", "INTEGER default '0' ");
    localStringBuilder.append(" captureUploadErrCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[39] = "captureUploadCounter";
    locala.EYv.put("captureUploadCounter", "INTEGER default '0' ");
    localStringBuilder.append(" captureUploadCounter INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[40] = "captureEnterTime";
    locala.EYv.put("captureEnterTime", "LONG");
    localStringBuilder.append(" captureEnterTime LONG");
    localStringBuilder.append(", ");
    locala.columns[41] = "lensId";
    locala.EYv.put("lensId", "TEXT");
    localStringBuilder.append(" lensId TEXT");
    localStringBuilder.append(", ");
    locala.columns[42] = "attachTextColor";
    locala.EYv.put("attachTextColor", "TEXT");
    localStringBuilder.append(" attachTextColor TEXT");
    localStringBuilder.append(", ");
    locala.columns[43] = "captureScene";
    locala.EYv.put("captureScene", "INTEGER");
    localStringBuilder.append(" captureScene INTEGER");
    locala.columns[44] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(105048);
  }
  
  public EmojiInfo()
  {
    AppMethodBeat.i(105022);
    this.LCo = 2;
    a locala = a.fSR;
    this.uLk = a.acD();
    reset();
    AppMethodBeat.o(105022);
  }
  
  protected EmojiInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(105047);
    this.LCo = 2;
    this.uLk = paramParcel.readString();
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
    AppMethodBeat.o(105047);
  }
  
  public EmojiInfo(String paramString)
  {
    AppMethodBeat.i(105023);
    this.LCo = 2;
    this.uLk = paramString;
    reset();
    AppMethodBeat.o(105023);
  }
  
  public static boolean ail(int paramInt)
  {
    return (paramInt == LBV) || (paramInt == LBU);
  }
  
  public static InputStream bZ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(105028);
    if ((paramContext == null) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(105028);
      return null;
    }
    try
    {
      paramString = paramString.split("\\.")[0];
      ad.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", new Object[] { paramString });
      int i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
      paramContext = paramContext.getResources().openRawResource(i);
      AppMethodBeat.o(105028);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ad.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(105028);
    }
    return null;
  }
  
  public static String gac()
  {
    AppMethodBeat.i(105042);
    Object localObject = a.fSR;
    localObject = a.acD();
    AppMethodBeat.o(105042);
    return localObject;
  }
  
  public final boolean CZ()
  {
    return (this.field_catalog == LBV) || (this.field_catalog == LBU);
  }
  
  public final void Cb(String paramString)
  {
    this.field_md5 = paramString;
  }
  
  public final String JS()
  {
    if (this.field_md5 == null) {
      return "";
    }
    return this.field_md5;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(105036);
    this.field_captureStatus = parama.ordinal();
    AppMethodBeat.o(105036);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(105037);
    this.field_captureUploadErrCode = paramb.ordinal();
    AppMethodBeat.o(105037);
  }
  
  public final void aWh(String paramString)
  {
    this.field_groupId = paramString;
  }
  
  public final void aim(int paramInt)
  {
    this.field_catalog = paramInt;
  }
  
  public final String asy()
  {
    return this.field_groupId;
  }
  
  /* Error */
  public final void bc(java.util.ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: ldc_w 607
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 609	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 610	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_2
    //   14: new 612	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 615	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 6
    //   24: aload 6
    //   26: astore 4
    //   28: aload_2
    //   29: astore_3
    //   30: aload 6
    //   32: aload_1
    //   33: invokevirtual 619	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   36: aload 6
    //   38: astore 4
    //   40: aload_2
    //   41: astore_3
    //   42: aload_0
    //   43: aload_2
    //   44: invokevirtual 623	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   47: putfield 495	com/tencent/mm/storage/emotion/EmojiInfo:field_attachedEmojiMD5	[B
    //   50: aload 6
    //   52: invokevirtual 626	java/io/ObjectOutputStream:close	()V
    //   55: aload_2
    //   56: invokevirtual 627	java/io/ByteArrayOutputStream:close	()V
    //   59: ldc_w 607
    //   62: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: astore_1
    //   67: ldc_w 546
    //   70: new 130	java/lang/StringBuilder
    //   73: dup
    //   74: ldc_w 629
    //   77: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: goto -38 -> 55
    //   96: astore_1
    //   97: ldc_w 546
    //   100: new 130	java/lang/StringBuilder
    //   103: dup
    //   104: ldc_w 637
    //   107: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload_1
    //   111: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: ldc_w 607
    //   126: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   141: ldc_w 546
    //   144: new 130	java/lang/StringBuilder
    //   147: dup
    //   148: ldc_w 639
    //   151: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload 5
    //   156: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 626	java/io/ObjectOutputStream:close	()V
    //   176: aload_2
    //   177: ifnull +7 -> 184
    //   180: aload_2
    //   181: invokevirtual 627	java/io/ByteArrayOutputStream:close	()V
    //   184: ldc_w 607
    //   187: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: return
    //   191: astore_1
    //   192: ldc_w 546
    //   195: new 130	java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w 629
    //   202: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: aload_1
    //   206: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: goto -42 -> 176
    //   221: astore_1
    //   222: ldc_w 546
    //   225: new 130	java/lang/StringBuilder
    //   228: dup
    //   229: ldc_w 637
    //   232: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload_1
    //   236: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   239: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: ldc_w 607
    //   251: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: return
    //   255: astore_1
    //   256: aconst_null
    //   257: astore 4
    //   259: aconst_null
    //   260: astore_2
    //   261: aload 4
    //   263: ifnull +8 -> 271
    //   266: aload 4
    //   268: invokevirtual 626	java/io/ObjectOutputStream:close	()V
    //   271: aload_2
    //   272: ifnull +7 -> 279
    //   275: aload_2
    //   276: invokevirtual 627	java/io/ByteArrayOutputStream:close	()V
    //   279: ldc_w 607
    //   282: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: aload_1
    //   286: athrow
    //   287: astore_3
    //   288: ldc_w 546
    //   291: new 130	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 629
    //   298: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: aload_3
    //   302: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: goto -43 -> 271
    //   317: astore_2
    //   318: ldc_w 546
    //   321: new 130	java/lang/StringBuilder
    //   324: dup
    //   325: ldc_w 637
    //   328: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: aload_2
    //   332: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean eip()
  {
    AppMethodBeat.i(105035);
    if (JS().length() == 32)
    {
      AppMethodBeat.o(105035);
      return true;
    }
    AppMethodBeat.o(105035);
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105044);
    if ((paramObject != null) && ((paramObject instanceof EmojiInfo)) && (((EmojiInfo)paramObject).JS().equalsIgnoreCase(this.field_md5)))
    {
      AppMethodBeat.o(105044);
      return true;
    }
    AppMethodBeat.o(105044);
    return false;
  }
  
  public final boolean fZM()
  {
    AppMethodBeat.i(105026);
    if ((this.field_catalog == LBS) || (this.field_catalog == EmojiGroupInfo.LBO) || (this.field_catalog == LBV) || (this.field_catalog == LBU))
    {
      AppMethodBeat.o(105026);
      return true;
    }
    Object localObject = gaa();
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(105026);
      return false;
    }
    localObject = new com.tencent.mm.vfs.e((String)localObject);
    if ((((com.tencent.mm.vfs.e)localObject).exists()) && (((com.tencent.mm.vfs.e)localObject).length() > 0L))
    {
      AppMethodBeat.o(105026);
      return true;
    }
    AppMethodBeat.o(105026);
    return false;
  }
  
  public final void fZN()
  {
    AppMethodBeat.i(105027);
    if ((this.field_catalog == LBS) || (this.field_catalog == LBV) || (this.field_catalog == LBU))
    {
      AppMethodBeat.o(105027);
      return;
    }
    Object localObject = gaa();
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = new com.tencent.mm.vfs.e((String)localObject);
      if (((com.tencent.mm.vfs.e)localObject).exists()) {
        ((com.tencent.mm.vfs.e)localObject).delete();
      }
    }
    AppMethodBeat.o(105027);
  }
  
  public final Bitmap fZO()
  {
    try
    {
      AppMethodBeat.i(177040);
      Bitmap localBitmap = fZP();
      AppMethodBeat.o(177040);
      return localBitmap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final Bitmap fZP()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 687
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 690	com/tencent/mm/storage/emotion/EmojiInfo:gab	()Ljava/lang/String;
    //   12: invokestatic 695	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   15: ifeq +26 -> 41
    //   18: aload_0
    //   19: invokevirtual 690	com/tencent/mm/storage/emotion/EmojiInfo:gab	()Ljava/lang/String;
    //   22: aconst_null
    //   23: invokestatic 701	com/tencent/mm/sdk/platformtools/f:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +13 -> 41
    //   31: ldc_w 687
    //   34: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: getstatic 707	com/tencent/mm/emoji/decode/MMGIFJNIFactory:Companion	Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion;
    //   44: aload_0
    //   45: invokevirtual 713	com/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion:decodeThumb	(Lcom/tencent/mm/storage/emotion/EmojiInfo;)Landroid/graphics/Bitmap;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +18 -> 68
    //   53: aload_1
    //   54: bipush 100
    //   56: getstatic 719	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   59: aload_0
    //   60: invokevirtual 690	com/tencent/mm/storage/emotion/EmojiInfo:gab	()Ljava/lang/String;
    //   63: iconst_0
    //   64: invokestatic 722	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   67: pop
    //   68: ldc_w 687
    //   71: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: goto -37 -> 37
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_2
    //   83: ldc_w 546
    //   86: aload_2
    //   87: ldc_w 724
    //   90: iconst_0
    //   91: anewarray 550	java/lang/Object
    //   94: invokestatic 728	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: goto -29 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	EmojiInfo
    //   26	28	1	localBitmap	Bitmap
    //   77	4	1	localObject	Object
    //   82	5	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	27	77	finally
    //   31	37	77	finally
    //   41	49	77	finally
    //   53	68	77	finally
    //   68	74	77	finally
    //   83	97	77	finally
    //   53	68	82	java/io/IOException
  }
  
  public final boolean fZQ()
  {
    return (this.field_catalog == LBS) || (this.field_catalog == LBV) || (this.field_catalog == LBU) || (this.field_catalog == EmojiGroupInfo.LBO);
  }
  
  public final boolean fZR()
  {
    AppMethodBeat.i(105032);
    boolean bool = this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
    AppMethodBeat.o(105032);
    return bool;
  }
  
  public final boolean fZS()
  {
    AppMethodBeat.i(105034);
    if (!bt.isNullOrNil(this.field_wxamMd5))
    {
      AppMethodBeat.o(105034);
      return true;
    }
    AppMethodBeat.o(105034);
    return false;
  }
  
  public final String fZT()
  {
    if (this.field_svrid == null) {
      return "";
    }
    return this.field_svrid;
  }
  
  public final void fZU()
  {
    this.field_temp = 1;
  }
  
  public final a fZV()
  {
    switch (this.field_captureStatus)
    {
    default: 
      return a.FBv;
    case 0: 
      return a.FBv;
    case 1: 
      return a.FBw;
    case 2: 
      return a.FBx;
    case 3: 
      return a.FBy;
    }
    return a.FBz;
  }
  
  public final int fZW()
  {
    return this.field_captureUploadCounter;
  }
  
  public final void fZX()
  {
    this.field_captureUploadCounter += 1;
  }
  
  public final b fZY()
  {
    switch (this.field_captureUploadErrCode)
    {
    default: 
      return b.FBH;
    case 0: 
      return b.FBB;
    case 1: 
      return b.FBC;
    case 2: 
      return b.FBD;
    case 3: 
      return b.FBE;
    case 4: 
      return b.FBF;
    case 5: 
      return b.FBG;
    case 6: 
      return b.FBH;
    case 7: 
      return b.FBI;
    case 8: 
      return b.FBJ;
    case 9: 
      return b.FBK;
    }
    return b.FBL;
  }
  
  /* Error */
  public final java.util.ArrayList<String> fZZ()
  {
    // Byte code:
    //   0: ldc_w 796
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 798	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: getfield 495	com/tencent/mm/storage/emotion/EmojiInfo:field_attachedEmojiMD5	[B
    //   14: invokespecial 800	java/io/ByteArrayInputStream:<init>	([B)V
    //   17: astore_2
    //   18: new 802	java/io/ObjectInputStream
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 805	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore 4
    //   30: aload_2
    //   31: astore_3
    //   32: aload_1
    //   33: invokevirtual 809	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   36: checkcast 811	java/util/ArrayList
    //   39: astore 5
    //   41: aload_2
    //   42: invokevirtual 812	java/io/ByteArrayInputStream:close	()V
    //   45: aload_1
    //   46: invokevirtual 813	java/io/ObjectInputStream:close	()V
    //   49: aload 5
    //   51: astore_1
    //   52: ldc_w 796
    //   55: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_1
    //   59: areturn
    //   60: astore_2
    //   61: ldc_w 546
    //   64: new 130	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 815
    //   71: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_2
    //   75: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   78: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -42 -> 45
    //   90: astore_1
    //   91: ldc_w 546
    //   94: new 130	java/lang/StringBuilder
    //   97: dup
    //   98: ldc_w 817
    //   101: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload_1
    //   105: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   108: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   134: ldc_w 546
    //   137: new 130	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 819
    //   144: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload 5
    //   149: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   152: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 812	java/io/ByteArrayInputStream:close	()V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 813	java/io/ObjectInputStream:close	()V
    //   177: aconst_null
    //   178: astore_1
    //   179: goto -127 -> 52
    //   182: astore_2
    //   183: ldc_w 546
    //   186: new 130	java/lang/StringBuilder
    //   189: dup
    //   190: ldc_w 815
    //   193: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: aload_2
    //   197: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: goto -40 -> 169
    //   212: astore_1
    //   213: ldc_w 546
    //   216: new 130	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 817
    //   223: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_1
    //   227: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   255: invokevirtual 812	java/io/ByteArrayInputStream:close	()V
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 813	java/io/ObjectInputStream:close	()V
    //   268: ldc_w 796
    //   271: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload_1
    //   275: athrow
    //   276: astore_2
    //   277: ldc_w 546
    //   280: new 130	java/lang/StringBuilder
    //   283: dup
    //   284: ldc_w 815
    //   287: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload_2
    //   291: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: goto -45 -> 258
    //   306: astore_2
    //   307: ldc_w 546
    //   310: new 130	java/lang/StringBuilder
    //   313: dup
    //   314: ldc_w 817
    //   317: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   320: aload_2
    //   321: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   324: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 635	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public final String gaa()
  {
    AppMethodBeat.i(105040);
    if ((bt.isNullOrNil(this.field_groupId)) && (bt.isNullOrNil(this.field_md5)))
    {
      ad.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. product id and md5 are null.");
      AppMethodBeat.o(105040);
      return null;
    }
    if (!bt.isNullOrNil(this.field_md5))
    {
      if ((bt.isNullOrNil(this.field_groupId)) || (bt.kU(this.field_groupId, "capture"))) {}
      for (String str = this.uLk;; str = this.uLk + this.field_groupId + "/")
      {
        com.tencent.mm.vfs.i.aMF(str);
        str = str + this.field_md5;
        AppMethodBeat.o(105040);
        return str;
      }
    }
    AppMethodBeat.o(105040);
    return null;
  }
  
  public final String gab()
  {
    AppMethodBeat.i(105041);
    String str1 = gaa();
    if (str1 == null) {}
    for (str1 = null; !com.tencent.mm.plugin.emoji.h.b.x(this); str1 = str1 + "_cover")
    {
      AppMethodBeat.o(105041);
      return str1;
    }
    if ((((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poB, 0) & 0x2) > 0)
    {
      String str2 = com.tencent.mm.loader.j.b.ahZ() + "emoji/cover/";
      String str3 = com.tencent.mm.loader.j.b.ahZ() + "emoji/cover/" + JS() + "_cover";
      if ((com.tencent.mm.vfs.i.eK(str1)) && (!com.tencent.mm.vfs.i.eK(str3)))
      {
        com.tencent.mm.vfs.i.aMF(str2);
        com.tencent.mm.vfs.i.lC(str1, str3);
      }
      ad.i("MicroMsg.emoji.EmojiInfo", "getCoverPath: from %s, to %s", new Object[] { str1, str3 });
      AppMethodBeat.o(105041);
      return str3;
    }
    AppMethodBeat.o(105041);
    return str1;
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
  
  public final boolean isGif()
  {
    return (this.field_type == LBY) || (this.field_type == LCa);
  }
  
  /* Error */
  public final byte[] lk(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 888
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: iflt +7 -> 14
    //   10: iload_2
    //   11: ifge +11 -> 22
    //   14: ldc_w 888
    //   17: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: aload_0
    //   23: getfield 396	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   26: getstatic 67	com/tencent/mm/storage/emotion/EmojiInfo:LBS	I
    //   29: if_icmpeq +23 -> 52
    //   32: aload_0
    //   33: getfield 396	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   36: getstatic 73	com/tencent/mm/storage/emotion/EmojiInfo:LBV	I
    //   39: if_icmpeq +13 -> 52
    //   42: aload_0
    //   43: getfield 396	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   46: getstatic 71	com/tencent/mm/storage/emotion/EmojiInfo:LBU	I
    //   49: if_icmpne +157 -> 206
    //   52: ldc_w 546
    //   55: ldc_w 890
    //   58: iconst_1
    //   59: anewarray 550	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: invokevirtual 892	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 556	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: invokestatic 898	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   75: aload_0
    //   76: invokevirtual 892	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   79: invokestatic 900	com/tencent/mm/storage/emotion/EmojiInfo:bZ	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   82: astore 6
    //   84: iload_1
    //   85: i2l
    //   86: lstore_3
    //   87: aload 6
    //   89: astore 5
    //   91: aload 6
    //   93: lload_3
    //   94: invokevirtual 906	java/io/InputStream:skip	(J)J
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
    //   117: invokevirtual 910	java/io/InputStream:read	([BII)I
    //   120: pop
    //   121: aload 6
    //   123: ifnull +8 -> 131
    //   126: aload 6
    //   128: invokevirtual 911	java/io/InputStream:close	()V
    //   131: ldc_w 888
    //   134: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload 7
    //   139: areturn
    //   140: astore 5
    //   142: ldc_w 546
    //   145: ldc_w 913
    //   148: iconst_1
    //   149: anewarray 550	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 5
    //   156: invokestatic 917	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 919	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: goto -32 -> 131
    //   166: astore 7
    //   168: aconst_null
    //   169: astore 6
    //   171: aload 6
    //   173: astore 5
    //   175: ldc_w 546
    //   178: ldc_w 913
    //   181: iconst_1
    //   182: anewarray 550	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload 7
    //   189: invokestatic 917	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 919	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload 6
    //   198: ifnull +8 -> 206
    //   201: aload 6
    //   203: invokevirtual 911	java/io/InputStream:close	()V
    //   206: aload_0
    //   207: invokevirtual 665	com/tencent/mm/storage/emotion/EmojiInfo:gaa	()Ljava/lang/String;
    //   210: aload_0
    //   211: getfield 405	com/tencent/mm/storage/emotion/EmojiInfo:field_start	I
    //   214: iload_2
    //   215: invokestatic 923	com/tencent/mm/vfs/i:aR	(Ljava/lang/String;II)[B
    //   218: astore 5
    //   220: ldc_w 888
    //   223: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload 5
    //   228: areturn
    //   229: astore 5
    //   231: ldc_w 546
    //   234: ldc_w 913
    //   237: iconst_1
    //   238: anewarray 550	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: aload 5
    //   245: invokestatic 917	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   248: aastore
    //   249: invokestatic 919	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: goto -46 -> 206
    //   255: astore 6
    //   257: aconst_null
    //   258: astore 5
    //   260: aload 5
    //   262: ifnull +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 911	java/io/InputStream:close	()V
    //   270: ldc_w 888
    //   273: invokestatic 357	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload 6
    //   278: athrow
    //   279: astore 5
    //   281: ldc_w 546
    //   284: ldc_w 913
    //   287: iconst_1
    //   288: anewarray 550	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: aload 5
    //   295: invokestatic 917	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   298: aastore
    //   299: invokestatic 919	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void reset()
  {
    AppMethodBeat.i(105024);
    this.field_md5 = "";
    this.field_svrid = "";
    this.field_catalog = LBS;
    this.field_type = LBX;
    this.field_size = 0;
    this.field_start = 0;
    this.field_state = LCc;
    this.field_name = "";
    this.field_content = "";
    this.field_reserved1 = "";
    this.field_reserved2 = "";
    this.field_reserved3 = 0;
    this.field_reserved4 = 0;
    this.field_app_id = "";
    this.field_temp = 0;
    this.field_captureStatus = a.FBv.ordinal();
    this.field_captureUploadErrCode = b.FBB.ordinal();
    this.field_captureUploadCounter = 0;
    this.field_imitateMd5 = "";
    this.field_attachedEmojiMD5 = new byte[0];
    AppMethodBeat.o(105024);
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
    AppMethodBeat.i(105045);
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
    AppMethodBeat.o(105045);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105046);
    paramParcel.writeString(this.uLk);
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
      AppMethodBeat.o(105046);
      return;
      paramParcel.writeInt(0);
    }
  }
  
  public final Bitmap z(Context paramContext, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(105030);
        if ((this.field_catalog == EmojiGroupInfo.LBO) || (this.field_catalog == LBV) || (this.field_catalog == LBU))
        {
          localObject = getName();
          if (!bt.isNullOrNil((String)localObject))
          {
            if (((String)localObject).startsWith("jsb"))
            {
              localObject = "jsb";
              paramInt = paramContext.getResources().getIdentifier((String)localObject, "drawable", aj.getPackageName());
              paramContext = f.B(paramContext.getResources().getDrawable(paramInt));
              ad.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(this.field_catalog), Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
              AppMethodBeat.o(105030);
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
          ad.i("MicroMsg.emoji.EmojiInfo", "name is null");
          ad.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", new Object[] { this });
          paramContext = null;
          AppMethodBeat.o(105030);
          continue;
        }
        if (this.field_catalog != EmojiGroupInfo.LBN) {
          break label400;
        }
      }
      finally {}
      localObject = getName();
      if (!bt.isNullOrNil((String)localObject)) {
        if (bt.isNullOrNil(getContent()))
        {
          localObject = getName();
          label268:
          localObject = ((String)localObject).replaceAll(".png", "");
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] drawable name:%s", new Object[] { localObject });
        paramInt = paramContext.getResources().getIdentifier((String)localObject, "drawable", aj.getPackageName());
        paramContext = f.B(paramContext.getResources().getDrawable(paramInt));
        ad.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(this.field_catalog), Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
        AppMethodBeat.o(105030);
        break;
        localObject = getContent();
        break label268;
        ad.i("MicroMsg.emoji.EmojiInfo", "name is null");
      }
      label400:
      paramContext = gab();
      boolean bool = com.tencent.mm.vfs.i.eK(paramContext);
      ad.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] thumbPath:%s isExist:%s", new Object[] { paramContext, Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      paramContext = gaa();
      bool = com.tencent.mm.vfs.i.eK(paramContext);
      if (bool)
      {
        paramContext = ((d)g.ad(d.class)).getProvider().a(this);
        if (paramContext == null)
        {
          ad.e("MicroMsg.emoji.EmojiInfo", "bytes is null!");
          paramContext = null;
          AppMethodBeat.o(105030);
        }
        else
        {
          ad.i("MicroMsg.emoji.EmojiInfo", "bytes size:%s", new Object[] { Integer.valueOf(paramContext.length) });
          if (t.cp(paramContext)) {}
          for (paramContext = com.tencent.mm.plugin.gif.i.bn(paramContext);; paramContext = f.decodeByteArray(paramContext, paramInt, paramInt))
          {
            if (paramContext != null) {
              ad.i("MicroMsg.emoji.EmojiInfo", "emoji:%s width:%s height:%s", new Object[] { this, Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
            }
            AppMethodBeat.o(105030);
            break;
          }
        }
      }
      else
      {
        ad.w("MicroMsg.emoji.EmojiInfo", "[addEmoji] Path:%s isExist:%s", new Object[] { paramContext, Boolean.valueOf(bool) });
      }
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(paramContext, (BitmapFactory.Options)localObject);
    label678:
    int j;
    if ((((BitmapFactory.Options)localObject).outHeight < paramInt) && (((BitmapFactory.Options)localObject).outWidth < paramInt))
    {
      paramContext = f.aD(paramContext, ((BitmapFactory.Options)localObject).outHeight, ((BitmapFactory.Options)localObject).outWidth);
      j = this.field_catalog;
      if (paramContext != null) {
        break label748;
      }
      paramInt = 0;
      label690:
      if (paramContext != null) {
        break label756;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(105030);
      break;
      paramContext = f.aD(paramContext, paramInt, paramInt);
      break label678;
      label748:
      paramInt = paramContext.getWidth();
      break label690;
      label756:
      i = paramContext.getHeight();
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(105018);
      FBv = new a("STATUS_SUCCESS", 0);
      FBw = new a("STATUS_MIXING", 1);
      FBx = new a("STATUS_MIX_FAIL", 2);
      FBy = new a("STATUS_UPLOADING", 3);
      FBz = new a("STATUS_UPLOAD_FAIL", 4);
      FBA = new a[] { FBv, FBw, FBx, FBy, FBz };
      AppMethodBeat.o(105018);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(105021);
      FBB = new b("ERR_SUCCESS", 0);
      FBC = new b("ERR_NON_NETWORK", 1);
      FBD = new b("ERR_WIFI_NETWORK", 2);
      FBE = new b("ERR_MOBILE_NETWORK", 3);
      FBF = new b("ERR_NOT_COMPLETED", 4);
      FBG = new b("ERR_OVER_LIMIT", 5);
      FBH = new b("ERR_OTHERS", 6);
      FBI = new b("ERR_LOCAL_FILE", 7);
      FBJ = new b("ERR_OVER_SIZE", 8);
      FBK = new b("ERR_SPAM", 9);
      FBL = new b("ERR_OVER_UPLOAD_TIME", 10);
      FBM = new b("ERR_MIX_VIDEO_ZERO_FRAME", 11);
      FBN = new b("ERR_MIX_OUTPUT_EMPTY", 12);
      FBO = new b("ERR_MIX_PROCESS_KILL", 13);
      FBP = new b[] { FBB, FBC, FBD, FBE, FBF, FBG, FBH, FBI, FBJ, FBK, FBL, FBM, FBN, FBO };
      AppMethodBeat.o(105021);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.EmojiInfo
 * JD-Core Version:    0.7.0.1
 */