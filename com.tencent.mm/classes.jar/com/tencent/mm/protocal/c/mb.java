package com.tencent.mm.protocal.c;

public final class mb
  extends com.tencent.mm.bv.a
{
  public float bRt;
  public float bTc;
  public String cCA;
  public String cCB;
  public String country;
  public String descriptor;
  public String ekZ;
  public String ilD;
  public String ina;
  public String name;
  public float sIe;
  public String sIf;
  public String sIg;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.descriptor != null) {
        paramVarArgs.d(2, this.descriptor);
      }
      if (this.ilD != null) {
        paramVarArgs.d(3, this.ilD);
      }
      if (this.country != null) {
        paramVarArgs.d(4, this.country);
      }
      if (this.cCA != null) {
        paramVarArgs.d(5, this.cCA);
      }
      if (this.cCB != null) {
        paramVarArgs.d(6, this.cCB);
      }
      if (this.ekZ != null) {
        paramVarArgs.d(7, this.ekZ);
      }
      paramVarArgs.m(8, this.sIe);
      paramVarArgs.m(9, this.bTc);
      paramVarArgs.m(10, this.bRt);
      if (this.ina != null) {
        paramVarArgs.d(11, this.ina);
      }
      if (this.sIf != null) {
        paramVarArgs.d(12, this.sIf);
      }
      if (this.sIg != null) {
        paramVarArgs.d(13, this.sIg);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label795;
      }
    }
    label795:
    for (int i = d.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.descriptor != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.descriptor);
      }
      i = paramInt;
      if (this.ilD != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ilD);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.country);
      }
      i = paramInt;
      if (this.cCA != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.cCA);
      }
      paramInt = i;
      if (this.cCB != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.cCB);
      }
      i = paramInt;
      if (this.ekZ != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.ekZ);
      }
      i = i + (d.a.a.b.b.a.dQ(8) + 4) + (d.a.a.b.b.a.dQ(9) + 4) + (d.a.a.b.b.a.dQ(10) + 4);
      paramInt = i;
      if (this.ina != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.ina);
      }
      i = paramInt;
      if (this.sIf != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.sIf);
      }
      paramInt = i;
      if (this.sIg != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.sIg);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        mb localmb = (mb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localmb.name = locala.xpH.readString();
          return 0;
        case 2: 
          localmb.descriptor = locala.xpH.readString();
          return 0;
        case 3: 
          localmb.ilD = locala.xpH.readString();
          return 0;
        case 4: 
          localmb.country = locala.xpH.readString();
          return 0;
        case 5: 
          localmb.cCA = locala.xpH.readString();
          return 0;
        case 6: 
          localmb.cCB = locala.xpH.readString();
          return 0;
        case 7: 
          localmb.ekZ = locala.xpH.readString();
          return 0;
        case 8: 
          localmb.sIe = locala.xpH.readFloat();
          return 0;
        case 9: 
          localmb.bTc = locala.xpH.readFloat();
          return 0;
        case 10: 
          localmb.bRt = locala.xpH.readFloat();
          return 0;
        case 11: 
          localmb.ina = locala.xpH.readString();
          return 0;
        case 12: 
          localmb.sIf = locala.xpH.readString();
          return 0;
        }
        localmb.sIg = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.mb
 * JD-Core Version:    0.7.0.1
 */