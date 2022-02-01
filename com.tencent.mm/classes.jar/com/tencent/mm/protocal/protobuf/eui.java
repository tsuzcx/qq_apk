package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eui
  extends dop
{
  public int LsZ;
  public long Lta;
  public int MKr;
  public int NpP;
  public LinkedList<csu> NpQ;
  public int Nsn;
  public int Nso;
  public LinkedList<eul> Nsp;
  public int Nsq;
  public int Nsr;
  public int Nss;
  
  public eui()
  {
    AppMethodBeat.i(115905);
    this.Nsp = new LinkedList();
    this.NpQ = new LinkedList();
    AppMethodBeat.o(115905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115906);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.aM(4, this.MKr);
      paramVarArgs.aM(5, this.Nsn);
      paramVarArgs.aM(6, this.Nso);
      paramVarArgs.e(7, 8, this.Nsp);
      paramVarArgs.aM(8, this.Nsq);
      paramVarArgs.aM(9, this.NpP);
      paramVarArgs.e(10, 8, this.NpQ);
      paramVarArgs.aM(11, this.Nsr);
      paramVarArgs.aM(12, this.Nss);
      AppMethodBeat.o(115906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LsZ);
      int j = g.a.a.b.b.a.r(3, this.Lta);
      int k = g.a.a.b.b.a.bu(4, this.MKr);
      int m = g.a.a.b.b.a.bu(5, this.Nsn);
      int n = g.a.a.b.b.a.bu(6, this.Nso);
      int i1 = g.a.a.a.c(7, 8, this.Nsp);
      int i2 = g.a.a.b.b.a.bu(8, this.Nsq);
      int i3 = g.a.a.b.b.a.bu(9, this.NpP);
      int i4 = g.a.a.a.c(10, 8, this.NpQ);
      int i5 = g.a.a.b.b.a.bu(11, this.Nsr);
      int i6 = g.a.a.b.b.a.bu(12, this.Nss);
      AppMethodBeat.o(115906);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nsp.clear();
        this.NpQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(115906);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eui localeui = (eui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115906);
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
            localeui.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 2: 
          localeui.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115906);
          return 0;
        case 3: 
          localeui.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115906);
          return 0;
        case 4: 
          localeui.MKr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115906);
          return 0;
        case 5: 
          localeui.Nsn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115906);
          return 0;
        case 6: 
          localeui.Nso = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115906);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eul();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eul)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeui.Nsp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 8: 
          localeui.Nsq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115906);
          return 0;
        case 9: 
          localeui.NpP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115906);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeui.NpQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 11: 
          localeui.Nsr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115906);
          return 0;
        }
        localeui.Nss = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115906);
        return 0;
      }
      AppMethodBeat.o(115906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eui
 * JD-Core Version:    0.7.0.1
 */