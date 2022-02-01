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
  public static final JceRequestType a;
  private static JceRequestType[] jdField_a_of_type_ArrayOfAcsJceRequestType = new JceRequestType[49];
  public static final JceRequestType b;
  public static final JceRequestType c;
  public static final JceRequestType d;
  public static final JceRequestType e;
  public static final JceRequestType f;
  public static final JceRequestType g;
  public static final JceRequestType h;
  public static final JceRequestType i;
  public static final JceRequestType j;
  public static final JceRequestType k;
  public static final JceRequestType l;
  public static final JceRequestType m;
  public static final JceRequestType n;
  public static final JceRequestType o;
  public static final JceRequestType p;
  public static final JceRequestType q;
  public static final JceRequestType r;
  public static final JceRequestType s;
  public static final JceRequestType t;
  public static final JceRequestType u;
  public static final JceRequestType v;
  public static final JceRequestType w;
  public static final JceRequestType x;
  public static final JceRequestType y;
  public static final JceRequestType z;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = new String();
  
  static
  {
    jdField_a_of_type_AcsJceRequestType = new JceRequestType(0, 0, "getCooperateCms");
    b = new JceRequestType(1, 1, "delAllShare");
    c = new JceRequestType(2, 2, "getSoftwaresOnTop");
    d = new JceRequestType(3, 3, "getG_fByQua");
    e = new JceRequestType(4, 4, "checkVerifyCode");
    f = new JceRequestType(5, 5, "getLoadingText");
    g = new JceRequestType(6, 6, "getSoftDetail");
    h = new JceRequestType(7, 7, "getFlashScreen");
    i = new JceRequestType(8, 8, "handshake");
    j = new JceRequestType(9, 9, "checkUpdate");
    k = new JceRequestType(10, 10, "reportStatData");
    l = new JceRequestType(11, 11, "getDayRecommend");
    m = new JceRequestType(12, 12, "randomFirstRelease");
    n = new JceRequestType(13, 13, "getPicAdv");
    o = new JceRequestType(14, 14, "hotSoftwares");
    p = new JceRequestType(15, 15, "relatedSoftwares");
    q = new JceRequestType(16, 16, "requiredSoftwares");
    r = new JceRequestType(17, 17, "latestSoftwares");
    s = new JceRequestType(18, 18, "listFriend");
    t = new JceRequestType(19, 19, "addShare");
    u = new JceRequestType(20, 20, "listComment");
    v = new JceRequestType(21, 21, "editComment");
    w = new JceRequestType(22, 22, "getStatus");
    x = new JceRequestType(23, 23, "setStatus");
    y = new JceRequestType(24, 24, "getUserCommends");
    z = new JceRequestType(25, 25, "guessIt");
  }
  
  private JceRequestType(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    jdField_a_of_type_ArrayOfAcsJceRequestType[paramInt1] = this;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acs.JceRequestType
 * JD-Core Version:    0.7.0.1
 */