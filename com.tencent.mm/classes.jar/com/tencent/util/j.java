package com.tencent.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  private static j Bzr;
  public static final String DEVICE;
  public static final String MANUFACTURER;
  public static final String MODEL;
  public boolean BzA;
  private boolean BzB;
  private boolean BzC;
  private int BzD;
  private boolean BzE;
  private boolean BzF;
  private boolean BzG;
  private boolean Bzq;
  private boolean Bzs;
  private boolean Bzt;
  private boolean Bzu;
  private int Bzv;
  private boolean Bzw;
  private boolean Bzx;
  private boolean Bzy;
  private boolean Bzz;
  private String cqJ;
  
  static
  {
    AppMethodBeat.i(86624);
    Bzr = null;
    MODEL = Build.MODEL.toLowerCase();
    DEVICE = Build.DEVICE.toLowerCase();
    MANUFACTURER = Build.MANUFACTURER.toLowerCase();
    AppMethodBeat.o(86624);
  }
  
  private j()
  {
    AppMethodBeat.i(86623);
    this.Bzq = false;
    this.cqJ = null;
    this.Bzs = false;
    this.Bzt = false;
    this.Bzu = false;
    this.Bzv = 0;
    this.Bzw = false;
    this.Bzx = false;
    this.Bzy = false;
    this.Bzz = false;
    this.BzA = false;
    this.BzB = false;
    this.BzC = false;
    this.BzD = 0;
    this.BzE = false;
    this.BzF = true;
    this.BzG = false;
    if (this.Bzq)
    {
      i.k("PhoneProperty", "******MODEL*****" + Build.MODEL);
      i.k("PhoneProperty", "******BRAND*****" + Build.BRAND);
      i.k("PhoneProperty", "*******DEVICE****" + Build.DEVICE);
      i.k("PhoneProperty", "*****DISPLAY******" + Build.DISPLAY);
      i.k("PhoneProperty", "*****HARDWARE******" + Build.HARDWARE);
      i.k("PhoneProperty", "******MANUFACTURER*****" + Build.MANUFACTURER);
      i.k("PhoneProperty", "*****PRODUCT******" + Build.PRODUCT);
      i.k("PhoneProperty", "******TAGS*****" + Build.TAGS);
      i.k("PhoneProperty", "*****USER******" + Build.USER);
      i.k("PhoneProperty", "****TYPE*******" + Build.TYPE);
    }
    AppMethodBeat.o(86623);
  }
  
  public static j dXc()
  {
    AppMethodBeat.i(86622);
    if (Bzr == null) {
      Bzr = new j();
    }
    j localj = Bzr;
    AppMethodBeat.o(86622);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.util.j
 * JD-Core Version:    0.7.0.1
 */