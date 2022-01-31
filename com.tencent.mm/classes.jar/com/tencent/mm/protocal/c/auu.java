package com.tencent.mm.protocal.c;

public final class auu
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public int group_id;
  public String sLq;
  public String tqA;
  public String tqB;
  public String tqC;
  public String tqD;
  public String tql;
  public String tqm;
  public String tqn;
  public String tqo;
  public int tqp;
  public int tqq;
  public String tqr;
  public int tqs;
  public int tqt;
  public String tqu;
  public int tqv;
  public int tqw;
  public String tqx;
  public int tqy;
  public int tqz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL != null) {
        paramVarArgs.d(1, this.bOL);
      }
      if (this.tql != null) {
        paramVarArgs.d(20, this.tql);
      }
      if (this.tqm != null) {
        paramVarArgs.d(21, this.tqm);
      }
      if (this.tqn != null) {
        paramVarArgs.d(22, this.tqn);
      }
      if (this.tqo != null) {
        paramVarArgs.d(23, this.tqo);
      }
      if (this.sLq != null) {
        paramVarArgs.d(31, this.sLq);
      }
      paramVarArgs.gB(32, this.tqp);
      paramVarArgs.gB(33, this.tqq);
      if (this.tqr != null) {
        paramVarArgs.d(34, this.tqr);
      }
      paramVarArgs.gB(35, this.tqs);
      paramVarArgs.gB(36, this.tqt);
      if (this.tqu != null) {
        paramVarArgs.d(37, this.tqu);
      }
      paramVarArgs.gB(38, this.tqv);
      paramVarArgs.gB(39, this.tqw);
      if (this.tqx != null) {
        paramVarArgs.d(41, this.tqx);
      }
      paramVarArgs.gB(200, this.tqy);
      paramVarArgs.gB(201, this.tqz);
      paramVarArgs.gB(202, this.group_id);
      if (this.tqA != null) {
        paramVarArgs.d(203, this.tqA);
      }
      if (this.tqB != null) {
        paramVarArgs.d(204, this.tqB);
      }
      if (this.tqC != null) {
        paramVarArgs.d(205, this.tqC);
      }
      if (this.tqD != null) {
        paramVarArgs.d(206, this.tqD);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOL == null) {
        break label1318;
      }
    }
    label1318:
    for (int i = d.a.a.b.b.a.e(1, this.bOL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tql != null) {
        paramInt = i + d.a.a.b.b.a.e(20, this.tql);
      }
      i = paramInt;
      if (this.tqm != null) {
        i = paramInt + d.a.a.b.b.a.e(21, this.tqm);
      }
      paramInt = i;
      if (this.tqn != null) {
        paramInt = i + d.a.a.b.b.a.e(22, this.tqn);
      }
      i = paramInt;
      if (this.tqo != null) {
        i = paramInt + d.a.a.b.b.a.e(23, this.tqo);
      }
      paramInt = i;
      if (this.sLq != null) {
        paramInt = i + d.a.a.b.b.a.e(31, this.sLq);
      }
      i = paramInt + d.a.a.a.gy(32, this.tqp) + d.a.a.a.gy(33, this.tqq);
      paramInt = i;
      if (this.tqr != null) {
        paramInt = i + d.a.a.b.b.a.e(34, this.tqr);
      }
      i = paramInt + d.a.a.a.gy(35, this.tqs) + d.a.a.a.gy(36, this.tqt);
      paramInt = i;
      if (this.tqu != null) {
        paramInt = i + d.a.a.b.b.a.e(37, this.tqu);
      }
      i = paramInt + d.a.a.a.gy(38, this.tqv) + d.a.a.a.gy(39, this.tqw);
      paramInt = i;
      if (this.tqx != null) {
        paramInt = i + d.a.a.b.b.a.e(41, this.tqx);
      }
      i = paramInt + d.a.a.a.gy(200, this.tqy) + d.a.a.a.gy(201, this.tqz) + d.a.a.a.gy(202, this.group_id);
      paramInt = i;
      if (this.tqA != null) {
        paramInt = i + d.a.a.b.b.a.e(203, this.tqA);
      }
      i = paramInt;
      if (this.tqB != null) {
        i = paramInt + d.a.a.b.b.a.e(204, this.tqB);
      }
      paramInt = i;
      if (this.tqC != null) {
        paramInt = i + d.a.a.b.b.a.e(205, this.tqC);
      }
      i = paramInt;
      if (this.tqD != null) {
        i = paramInt + d.a.a.b.b.a.e(206, this.tqD);
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
        auu localauu = (auu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localauu.bOL = locala.xpH.readString();
          return 0;
        case 20: 
          localauu.tql = locala.xpH.readString();
          return 0;
        case 21: 
          localauu.tqm = locala.xpH.readString();
          return 0;
        case 22: 
          localauu.tqn = locala.xpH.readString();
          return 0;
        case 23: 
          localauu.tqo = locala.xpH.readString();
          return 0;
        case 31: 
          localauu.sLq = locala.xpH.readString();
          return 0;
        case 32: 
          localauu.tqp = locala.xpH.oD();
          return 0;
        case 33: 
          localauu.tqq = locala.xpH.oD();
          return 0;
        case 34: 
          localauu.tqr = locala.xpH.readString();
          return 0;
        case 35: 
          localauu.tqs = locala.xpH.oD();
          return 0;
        case 36: 
          localauu.tqt = locala.xpH.oD();
          return 0;
        case 37: 
          localauu.tqu = locala.xpH.readString();
          return 0;
        case 38: 
          localauu.tqv = locala.xpH.oD();
          return 0;
        case 39: 
          localauu.tqw = locala.xpH.oD();
          return 0;
        case 41: 
          localauu.tqx = locala.xpH.readString();
          return 0;
        case 200: 
          localauu.tqy = locala.xpH.oD();
          return 0;
        case 201: 
          localauu.tqz = locala.xpH.oD();
          return 0;
        case 202: 
          localauu.group_id = locala.xpH.oD();
          return 0;
        case 203: 
          localauu.tqA = locala.xpH.readString();
          return 0;
        case 204: 
          localauu.tqB = locala.xpH.readString();
          return 0;
        case 205: 
          localauu.tqC = locala.xpH.readString();
          return 0;
        }
        localauu.tqD = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.auu
 * JD-Core Version:    0.7.0.1
 */