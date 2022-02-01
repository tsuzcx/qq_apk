package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dth
  extends dop
{
  public int KKA;
  public int LbL;
  public int LbM;
  public String LbN;
  public int LsF;
  public fd MVu;
  public String MVv;
  public String MVw;
  public int MVx;
  public int MVy;
  public String Md5;
  public String keb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MVu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Msg");
        AppMethodBeat.o(32426);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MVu != null)
      {
        paramVarArgs.ni(2, this.MVu.computeSize());
        this.MVu.writeFields(paramVarArgs);
      }
      if (this.MVv != null) {
        paramVarArgs.e(3, this.MVv);
      }
      paramVarArgs.aM(4, this.LsF);
      if (this.Md5 != null) {
        paramVarArgs.e(5, this.Md5);
      }
      paramVarArgs.aM(6, this.KKA);
      if (this.keb != null) {
        paramVarArgs.e(7, this.keb);
      }
      if (this.MVw != null) {
        paramVarArgs.e(8, this.MVw);
      }
      paramVarArgs.aM(9, this.MVx);
      paramVarArgs.aM(10, this.LbL);
      paramVarArgs.aM(11, this.LbM);
      paramVarArgs.aM(12, this.MVy);
      if (this.LbN != null) {
        paramVarArgs.e(13, this.LbN);
      }
      AppMethodBeat.o(32426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1109;
      }
    }
    label1109:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MVu != null) {
        paramInt = i + g.a.a.a.nh(2, this.MVu.computeSize());
      }
      i = paramInt;
      if (this.MVv != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MVv);
      }
      i += g.a.a.b.b.a.bu(4, this.LsF);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Md5);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.KKA);
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.keb);
      }
      i = paramInt;
      if (this.MVw != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MVw);
      }
      i = i + g.a.a.b.b.a.bu(9, this.MVx) + g.a.a.b.b.a.bu(10, this.LbL) + g.a.a.b.b.a.bu(11, this.LbM) + g.a.a.b.b.a.bu(12, this.MVy);
      paramInt = i;
      if (this.LbN != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.LbN);
      }
      AppMethodBeat.o(32426);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MVu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Msg");
          AppMethodBeat.o(32426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dth localdth = (dth)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32426);
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
            localdth.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdth.MVu = ((fd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 3: 
          localdth.MVv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 4: 
          localdth.LsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32426);
          return 0;
        case 5: 
          localdth.Md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 6: 
          localdth.KKA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32426);
          return 0;
        case 7: 
          localdth.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 8: 
          localdth.MVw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 9: 
          localdth.MVx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32426);
          return 0;
        case 10: 
          localdth.LbL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32426);
          return 0;
        case 11: 
          localdth.LbM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32426);
          return 0;
        case 12: 
          localdth.MVy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32426);
          return 0;
        }
        localdth.LbN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32426);
        return 0;
      }
      AppMethodBeat.o(32426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dth
 * JD-Core Version:    0.7.0.1
 */