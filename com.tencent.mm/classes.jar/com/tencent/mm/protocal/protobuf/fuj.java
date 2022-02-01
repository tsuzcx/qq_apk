package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fuj
  extends esc
{
  public int CreateTime;
  public String IMg;
  public String IMh;
  public int Njs;
  public long Njv;
  public String YHk;
  public int YTh;
  public int YWB;
  public int YYs;
  public int ZaS;
  public int Zsp;
  public int oOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148662);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IMh != null) {
        paramVarArgs.g(1, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(2, this.IMg);
      }
      paramVarArgs.bS(3, this.YYs);
      paramVarArgs.bS(4, this.YTh);
      paramVarArgs.bS(5, this.CreateTime);
      if (this.YHk != null) {
        paramVarArgs.g(6, this.YHk);
      }
      paramVarArgs.bS(7, this.Njs);
      paramVarArgs.bS(8, this.YWB);
      paramVarArgs.bS(9, this.oOu);
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(10, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.Zsp);
      paramVarArgs.bv(12, this.Njv);
      paramVarArgs.bS(13, this.ZaS);
      AppMethodBeat.o(148662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IMh == null) {
        break label872;
      }
    }
    label872:
    for (paramInt = i.a.a.b.b.a.h(1, this.IMh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IMg != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IMg);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.YYs) + i.a.a.b.b.a.cJ(4, this.YTh) + i.a.a.b.b.a.cJ(5, this.CreateTime);
      paramInt = i;
      if (this.YHk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YHk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.Njs) + i.a.a.b.b.a.cJ(8, this.YWB) + i.a.a.b.b.a.cJ(9, this.oOu);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + i.a.a.a.qC(10, this.BaseResponse.computeSize());
      }
      i = i.a.a.b.b.a.cJ(11, this.Zsp);
      int j = i.a.a.b.b.a.q(12, this.Njv);
      int k = i.a.a.b.b.a.cJ(13, this.ZaS);
      AppMethodBeat.o(148662);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(148662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fuj localfuj = (fuj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148662);
          return -1;
        case 1: 
          localfuj.IMh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 2: 
          localfuj.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 3: 
          localfuj.YYs = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(148662);
          return 0;
        case 4: 
          localfuj.YTh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(148662);
          return 0;
        case 5: 
          localfuj.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(148662);
          return 0;
        case 6: 
          localfuj.YHk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 7: 
          localfuj.Njs = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(148662);
          return 0;
        case 8: 
          localfuj.YWB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(148662);
          return 0;
        case 9: 
          localfuj.oOu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(148662);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localfuj.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(148662);
          return 0;
        case 11: 
          localfuj.Zsp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(148662);
          return 0;
        case 12: 
          localfuj.Njv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(148662);
          return 0;
        }
        localfuj.ZaS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(148662);
        return 0;
      }
      AppMethodBeat.o(148662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fuj
 * JD-Core Version:    0.7.0.1
 */