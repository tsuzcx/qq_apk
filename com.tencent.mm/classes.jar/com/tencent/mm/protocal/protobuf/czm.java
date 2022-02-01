package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czm
  extends dop
{
  public String LQv;
  public bf Lcc;
  public String Lkp;
  public String Lkq;
  public String Lkr;
  public String Lks;
  public String MEM;
  public String MEN;
  public String MEO;
  public String MEP;
  public String MEQ;
  public String jfi;
  public String xMq;
  public String xuk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91571);
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
      if (this.MEM != null) {
        paramVarArgs.e(3, this.MEM);
      }
      if (this.LQv != null) {
        paramVarArgs.e(4, this.LQv);
      }
      if (this.Lkp != null) {
        paramVarArgs.e(5, this.Lkp);
      }
      if (this.MEN != null) {
        paramVarArgs.e(6, this.MEN);
      }
      if (this.Lkq != null) {
        paramVarArgs.e(7, this.Lkq);
      }
      if (this.Lkr != null) {
        paramVarArgs.e(8, this.Lkr);
      }
      if (this.Lks != null) {
        paramVarArgs.e(9, this.Lks);
      }
      if (this.MEO != null) {
        paramVarArgs.e(10, this.MEO);
      }
      if (this.Lcc != null)
      {
        paramVarArgs.ni(11, this.Lcc.computeSize());
        this.Lcc.writeFields(paramVarArgs);
      }
      if (this.MEP != null) {
        paramVarArgs.e(12, this.MEP);
      }
      if (this.xuk != null) {
        paramVarArgs.e(13, this.xuk);
      }
      if (this.xMq != null) {
        paramVarArgs.e(14, this.xMq);
      }
      if (this.MEQ != null) {
        paramVarArgs.e(15, this.MEQ);
      }
      AppMethodBeat.o(91571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1266;
      }
    }
    label1266:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.MEM != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MEM);
      }
      paramInt = i;
      if (this.LQv != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LQv);
      }
      i = paramInt;
      if (this.Lkp != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lkp);
      }
      paramInt = i;
      if (this.MEN != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MEN);
      }
      i = paramInt;
      if (this.Lkq != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lkq);
      }
      paramInt = i;
      if (this.Lkr != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Lkr);
      }
      i = paramInt;
      if (this.Lks != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Lks);
      }
      paramInt = i;
      if (this.MEO != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MEO);
      }
      i = paramInt;
      if (this.Lcc != null) {
        i = paramInt + g.a.a.a.nh(11, this.Lcc.computeSize());
      }
      paramInt = i;
      if (this.MEP != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MEP);
      }
      i = paramInt;
      if (this.xuk != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.xuk);
      }
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.xMq);
      }
      i = paramInt;
      if (this.MEQ != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.MEQ);
      }
      AppMethodBeat.o(91571);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        czm localczm = (czm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91571);
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
            localczm.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 2: 
          localczm.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 3: 
          localczm.MEM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 4: 
          localczm.LQv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 5: 
          localczm.Lkp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 6: 
          localczm.MEN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 7: 
          localczm.Lkq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 8: 
          localczm.Lkr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 9: 
          localczm.Lks = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 10: 
          localczm.MEO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localczm.Lcc = ((bf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 12: 
          localczm.MEP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 13: 
          localczm.xuk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 14: 
          localczm.xMq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91571);
          return 0;
        }
        localczm.MEQ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91571);
        return 0;
      }
      AppMethodBeat.o(91571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czm
 * JD-Core Version:    0.7.0.1
 */