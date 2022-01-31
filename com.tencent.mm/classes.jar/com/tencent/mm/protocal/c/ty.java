package com.tencent.mm.protocal.c;

public final class ty
  extends com.tencent.mm.bv.a
{
  public String deviceBrand;
  public String deviceModel;
  public String osName;
  public String osVersion;
  public String sQM;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.deviceModel != null) {
        paramVarArgs.d(1, this.deviceModel);
      }
      if (this.deviceBrand != null) {
        paramVarArgs.d(2, this.deviceBrand);
      }
      if (this.osName != null) {
        paramVarArgs.d(3, this.osName);
      }
      if (this.osVersion != null) {
        paramVarArgs.d(4, this.osVersion);
      }
      if (this.sQM != null) {
        paramVarArgs.d(5, this.sQM);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.deviceModel == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.deviceModel) + 0;; i = 0)
    {
      paramInt = i;
      if (this.deviceBrand != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.deviceBrand);
      }
      i = paramInt;
      if (this.osName != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.osName);
      }
      paramInt = i;
      if (this.osVersion != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.osVersion);
      }
      i = paramInt;
      if (this.sQM != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sQM);
      }
      return i;
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
        ty localty = (ty)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localty.deviceModel = locala.xpH.readString();
          return 0;
        case 2: 
          localty.deviceBrand = locala.xpH.readString();
          return 0;
        case 3: 
          localty.osName = locala.xpH.readString();
          return 0;
        case 4: 
          localty.osVersion = locala.xpH.readString();
          return 0;
        }
        localty.sQM = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ty
 * JD-Core Version:    0.7.0.1
 */