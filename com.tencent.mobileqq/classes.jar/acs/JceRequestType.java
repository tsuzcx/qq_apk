package acs;

public final class JceRequestType
{
  public static final JceRequestType A = new JceRequestType(26, 26, "labelSearch");
  public static final JceRequestType B = new JceRequestType(27, 27, "getCategory");
  public static final JceRequestType C = new JceRequestType(28, 28, "getTopic");
  public static final JceRequestType D = new JceRequestType(29, 29, "getHotwords");
  public static final JceRequestType E = new JceRequestType(30, 30, "getShare");
  public static final JceRequestType F = new JceRequestType(31, 31, "wordSearch");
  public static final JceRequestType G = new JceRequestType(32, 32, "sortSoftwares");
  public static final JceRequestType H = new JceRequestType(33, 33, "widgetDayRecommend");
  public static final JceRequestType I = new JceRequestType(34, 34, "getAdvert");
  public static final JceRequestType J = new JceRequestType(35, 35, "listFavoriten");
  public static final JceRequestType K = new JceRequestType(36, 36, "addFavoriten");
  public static final JceRequestType L = new JceRequestType(37, 37, "delFavoriten");
  public static final JceRequestType M = new JceRequestType(38, 38, "editFavoriten");
  public static final JceRequestType N = new JceRequestType(39, 39, "scoreFavoriten");
  public static final JceRequestType O = new JceRequestType(40, 40, "listFavoritenSoft");
  public static final JceRequestType P = new JceRequestType(41, 41, "addFavoritenSoft");
  public static final JceRequestType Q = new JceRequestType(42, 42, "delFavoritenSoft");
  public static final JceRequestType R = new JceRequestType(43, 43, "addLabel");
  public static final JceRequestType S = new JceRequestType(44, 44, "getFeed");
  public static final JceRequestType T = new JceRequestType(45, 45, "friendFeed");
  public static final JceRequestType U = new JceRequestType(46, 46, "reportDownSoft");
  public static final JceRequestType V = new JceRequestType(47, 47, "reportAdData");
  public static final JceRequestType W = new JceRequestType(48, 48, "getConfig");
  private static JceRequestType[] Y = new JceRequestType[49];
  public static final JceRequestType a = new JceRequestType(0, 0, "getCooperateCms");
  public static final JceRequestType b = new JceRequestType(1, 1, "delAllShare");
  public static final JceRequestType c = new JceRequestType(2, 2, "getSoftwaresOnTop");
  public static final JceRequestType d = new JceRequestType(3, 3, "getG_fByQua");
  public static final JceRequestType e = new JceRequestType(4, 4, "checkVerifyCode");
  public static final JceRequestType f = new JceRequestType(5, 5, "getLoadingText");
  public static final JceRequestType g = new JceRequestType(6, 6, "getSoftDetail");
  public static final JceRequestType h = new JceRequestType(7, 7, "getFlashScreen");
  public static final JceRequestType i = new JceRequestType(8, 8, "handshake");
  public static final JceRequestType j = new JceRequestType(9, 9, "checkUpdate");
  public static final JceRequestType k = new JceRequestType(10, 10, "reportStatData");
  public static final JceRequestType l = new JceRequestType(11, 11, "getDayRecommend");
  public static final JceRequestType m = new JceRequestType(12, 12, "randomFirstRelease");
  public static final JceRequestType n = new JceRequestType(13, 13, "getPicAdv");
  public static final JceRequestType o = new JceRequestType(14, 14, "hotSoftwares");
  public static final JceRequestType p = new JceRequestType(15, 15, "relatedSoftwares");
  public static final JceRequestType q = new JceRequestType(16, 16, "requiredSoftwares");
  public static final JceRequestType r = new JceRequestType(17, 17, "latestSoftwares");
  public static final JceRequestType s = new JceRequestType(18, 18, "listFriend");
  public static final JceRequestType t = new JceRequestType(19, 19, "addShare");
  public static final JceRequestType u = new JceRequestType(20, 20, "listComment");
  public static final JceRequestType v = new JceRequestType(21, 21, "editComment");
  public static final JceRequestType w = new JceRequestType(22, 22, "getStatus");
  public static final JceRequestType x = new JceRequestType(23, 23, "setStatus");
  public static final JceRequestType y = new JceRequestType(24, 24, "getUserCommends");
  public static final JceRequestType z = new JceRequestType(25, 25, "guessIt");
  private int Z;
  private String aa = new String();
  
  private JceRequestType(int paramInt1, int paramInt2, String paramString)
  {
    this.aa = paramString;
    this.Z = paramInt2;
    Y[paramInt1] = this;
  }
  
  public String toString()
  {
    return this.aa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acs.JceRequestType
 * JD-Core Version:    0.7.0.1
 */