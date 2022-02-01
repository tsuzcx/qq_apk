package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anr
  extends ckq
{
  public String CFH;
  public az CPi;
  public String CWf;
  public String CXk;
  public String CXl;
  public String CXm;
  public String CXn;
  public int Ctl;
  public String DoO;
  public String DoR;
  public String DoS;
  public int DoT;
  public String DoU;
  public int Scene;
  public String hnC;
  public String sed;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.CXk != null) {
        paramVarArgs.d(3, this.CXk);
      }
      if (this.CFH != null) {
        paramVarArgs.d(4, this.CFH);
      }
      if (this.CXl != null) {
        paramVarArgs.d(5, this.CXl);
      }
      if (this.CXm != null) {
        paramVarArgs.d(6, this.CXm);
      }
      if (this.CXn != null) {
        paramVarArgs.d(7, this.CXn);
      }
      if (this.CWf != null) {
        paramVarArgs.d(8, this.CWf);
      }
      if (this.DoO != null) {
        paramVarArgs.d(9, this.DoO);
      }
      paramVarArgs.aR(10, this.Ctl);
      if (this.sed != null) {
        paramVarArgs.d(11, this.sed);
      }
      if (this.DoR != null) {
        paramVarArgs.d(12, this.DoR);
      }
      if (this.DoS != null) {
        paramVarArgs.d(13, this.DoS);
      }
      if (this.CPi != null)
      {
        paramVarArgs.kX(14, this.CPi.computeSize());
        this.CPi.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(15, this.Scene);
      paramVarArgs.aR(16, this.DoT);
      if (this.DoU != null) {
        paramVarArgs.d(17, this.DoU);
      }
      AppMethodBeat.o(91473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1338;
      }
    }
    label1338:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.CXk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CXk);
      }
      paramInt = i;
      if (this.CFH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CFH);
      }
      i = paramInt;
      if (this.CXl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CXl);
      }
      paramInt = i;
      if (this.CXm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CXm);
      }
      i = paramInt;
      if (this.CXn != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CXn);
      }
      paramInt = i;
      if (this.CWf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CWf);
      }
      i = paramInt;
      if (this.DoO != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DoO);
      }
      i += f.a.a.b.b.a.bA(10, this.Ctl);
      paramInt = i;
      if (this.sed != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.sed);
      }
      i = paramInt;
      if (this.DoR != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DoR);
      }
      paramInt = i;
      if (this.DoS != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DoS);
      }
      i = paramInt;
      if (this.CPi != null) {
        i = paramInt + f.a.a.a.kW(14, this.CPi.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(15, this.Scene) + f.a.a.b.b.a.bA(16, this.DoT);
      paramInt = i;
      if (this.DoU != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.DoU);
      }
      AppMethodBeat.o(91473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anr localanr = (anr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91473);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 2: 
          localanr.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 3: 
          localanr.CXk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 4: 
          localanr.CFH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 5: 
          localanr.CXl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 6: 
          localanr.CXm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 7: 
          localanr.CXn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 8: 
          localanr.CWf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 9: 
          localanr.DoO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 10: 
          localanr.Ctl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91473);
          return 0;
        case 11: 
          localanr.sed = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 12: 
          localanr.DoR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 13: 
          localanr.DoS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new az();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanr.CPi = ((az)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 15: 
          localanr.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91473);
          return 0;
        case 16: 
          localanr.DoT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91473);
          return 0;
        }
        localanr.DoU = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91473);
        return 0;
      }
      AppMethodBeat.o(91473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anr
 * JD-Core Version:    0.7.0.1
 */