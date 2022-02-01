package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class byz
  extends dpc
{
  public int KSa;
  public int LUr;
  public cyd Mei;
  public LinkedList<crb> Meo;
  public String Mep;
  public String Meq;
  public String Mer;
  public String Mes;
  public String Met;
  public LinkedList<fdt> Meu;
  public String dNI;
  public String dPS;
  public String qGr;
  public int ret;
  public String url;
  
  public byz()
  {
    AppMethodBeat.i(123588);
    this.Meo = new LinkedList();
    this.Meu = new LinkedList();
    AppMethodBeat.o(123588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123589);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.ret);
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      paramVarArgs.aM(4, this.LUr);
      if (this.dPS != null) {
        paramVarArgs.e(5, this.dPS);
      }
      if (this.Mei != null)
      {
        paramVarArgs.ni(6, this.Mei.computeSize());
        this.Mei.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.Meo);
      if (this.Mep != null) {
        paramVarArgs.e(8, this.Mep);
      }
      if (this.qGr != null) {
        paramVarArgs.e(9, this.qGr);
      }
      paramVarArgs.aM(10, this.KSa);
      if (this.dNI != null) {
        paramVarArgs.e(11, this.dNI);
      }
      if (this.Meq != null) {
        paramVarArgs.e(12, this.Meq);
      }
      if (this.Mer != null) {
        paramVarArgs.e(13, this.Mer);
      }
      if (this.Mes != null) {
        paramVarArgs.e(14, this.Mes);
      }
      if (this.Met != null) {
        paramVarArgs.e(15, this.Met);
      }
      paramVarArgs.e(16, 8, this.Meu);
      AppMethodBeat.o(123589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.ret);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.LUr);
      paramInt = i;
      if (this.dPS != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dPS);
      }
      i = paramInt;
      if (this.Mei != null) {
        i = paramInt + g.a.a.a.nh(6, this.Mei.computeSize());
      }
      i += g.a.a.a.c(7, 8, this.Meo);
      paramInt = i;
      if (this.Mep != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mep);
      }
      i = paramInt;
      if (this.qGr != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.qGr);
      }
      i += g.a.a.b.b.a.bu(10, this.KSa);
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.dNI);
      }
      i = paramInt;
      if (this.Meq != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Meq);
      }
      paramInt = i;
      if (this.Mer != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Mer);
      }
      i = paramInt;
      if (this.Mes != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.Mes);
      }
      paramInt = i;
      if (this.Met != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.Met);
      }
      i = g.a.a.a.c(16, 8, this.Meu);
      AppMethodBeat.o(123589);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Meo.clear();
        this.Meu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        byz localbyz = (byz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123589);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbyz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 2: 
          localbyz.ret = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123589);
          return 0;
        case 3: 
          localbyz.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 4: 
          localbyz.LUr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123589);
          return 0;
        case 5: 
          localbyz.dPS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbyz.Mei = ((cyd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbyz.Meo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123589);
          return 0;
        case 8: 
          localbyz.Mep = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 9: 
          localbyz.qGr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 10: 
          localbyz.KSa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123589);
          return 0;
        case 11: 
          localbyz.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 12: 
          localbyz.Meq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 13: 
          localbyz.Mer = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 14: 
          localbyz.Mes = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123589);
          return 0;
        case 15: 
          localbyz.Met = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123589);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fdt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fdt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbyz.Meu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123589);
        return 0;
      }
      AppMethodBeat.o(123589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byz
 * JD-Core Version:    0.7.0.1
 */