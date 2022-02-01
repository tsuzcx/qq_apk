package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgr
  extends dop
{
  public int KCx;
  public String KPJ;
  public String LQA;
  public String LQu;
  public String LQx;
  public String LQy;
  public int LQz;
  public bf Lcc;
  public String Ljk;
  public String Lkp;
  public String Lkq;
  public String Lkr;
  public String Lks;
  public int Scene;
  public String jfi;
  public String xNU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91473);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.Lkp != null) {
        paramVarArgs.e(3, this.Lkp);
      }
      if (this.KPJ != null) {
        paramVarArgs.e(4, this.KPJ);
      }
      if (this.Lkq != null) {
        paramVarArgs.e(5, this.Lkq);
      }
      if (this.Lkr != null) {
        paramVarArgs.e(6, this.Lkr);
      }
      if (this.Lks != null) {
        paramVarArgs.e(7, this.Lks);
      }
      if (this.Ljk != null) {
        paramVarArgs.e(8, this.Ljk);
      }
      if (this.LQu != null) {
        paramVarArgs.e(9, this.LQu);
      }
      paramVarArgs.aM(10, this.KCx);
      if (this.xNU != null) {
        paramVarArgs.e(11, this.xNU);
      }
      if (this.LQx != null) {
        paramVarArgs.e(12, this.LQx);
      }
      if (this.LQy != null) {
        paramVarArgs.e(13, this.LQy);
      }
      if (this.Lcc != null)
      {
        paramVarArgs.ni(14, this.Lcc.computeSize());
        this.Lcc.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(15, this.Scene);
      paramVarArgs.aM(16, this.LQz);
      if (this.LQA != null) {
        paramVarArgs.e(17, this.LQA);
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
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.Lkp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Lkp);
      }
      paramInt = i;
      if (this.KPJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KPJ);
      }
      i = paramInt;
      if (this.Lkq != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lkq);
      }
      paramInt = i;
      if (this.Lkr != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lkr);
      }
      i = paramInt;
      if (this.Lks != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lks);
      }
      paramInt = i;
      if (this.Ljk != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Ljk);
      }
      i = paramInt;
      if (this.LQu != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LQu);
      }
      i += g.a.a.b.b.a.bu(10, this.KCx);
      paramInt = i;
      if (this.xNU != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.xNU);
      }
      i = paramInt;
      if (this.LQx != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.LQx);
      }
      paramInt = i;
      if (this.LQy != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.LQy);
      }
      i = paramInt;
      if (this.Lcc != null) {
        i = paramInt + g.a.a.a.nh(14, this.Lcc.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(15, this.Scene) + g.a.a.b.b.a.bu(16, this.LQz);
      paramInt = i;
      if (this.LQA != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.LQA);
      }
      AppMethodBeat.o(91473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgr localbgr = (bgr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91473);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgr.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 2: 
          localbgr.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 3: 
          localbgr.Lkp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 4: 
          localbgr.KPJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 5: 
          localbgr.Lkq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 6: 
          localbgr.Lkr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 7: 
          localbgr.Lks = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 8: 
          localbgr.Ljk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 9: 
          localbgr.LQu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 10: 
          localbgr.KCx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91473);
          return 0;
        case 11: 
          localbgr.xNU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 12: 
          localbgr.LQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 13: 
          localbgr.LQy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgr.Lcc = ((bf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 15: 
          localbgr.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91473);
          return 0;
        case 16: 
          localbgr.LQz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91473);
          return 0;
        }
        localbgr.LQA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91473);
        return 0;
      }
      AppMethodBeat.o(91473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgr
 * JD-Core Version:    0.7.0.1
 */