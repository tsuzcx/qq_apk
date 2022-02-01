package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bpe
  extends dpc
{
  public int KZh;
  public String KZj;
  public SKBuiltinBuffer_t LXm;
  public int LXr;
  public LinkedList<dqi> LXs;
  public int LXt;
  public LinkedList<chj> LXu;
  public String LXv;
  public int LXw;
  public int LXx;
  public chk LXy;
  public String LXz;
  public String kea;
  
  public bpe()
  {
    AppMethodBeat.i(32251);
    this.LXs = new LinkedList();
    this.LXu = new LinkedList();
    AppMethodBeat.o(32251);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32252);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.LXm == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LXm != null)
      {
        paramVarArgs.ni(2, this.LXm.computeSize());
        this.LXm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.LXr);
      paramVarArgs.e(4, 8, this.LXs);
      paramVarArgs.aM(5, this.LXt);
      paramVarArgs.e(6, 8, this.LXu);
      paramVarArgs.aM(7, this.KZh);
      if (this.LXv != null) {
        paramVarArgs.e(8, this.LXv);
      }
      if (this.KZj != null) {
        paramVarArgs.e(9, this.KZj);
      }
      paramVarArgs.aM(10, this.LXw);
      if (this.kea != null) {
        paramVarArgs.e(11, this.kea);
      }
      paramVarArgs.aM(12, this.LXx);
      if (this.LXy != null)
      {
        paramVarArgs.ni(13, this.LXy.computeSize());
        this.LXy.writeFields(paramVarArgs);
      }
      if (this.LXz != null) {
        paramVarArgs.e(14, this.LXz);
      }
      AppMethodBeat.o(32252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1490;
      }
    }
    label1490:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LXm != null) {
        i = paramInt + g.a.a.a.nh(2, this.LXm.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.LXr) + g.a.a.a.c(4, 8, this.LXs) + g.a.a.b.b.a.bu(5, this.LXt) + g.a.a.a.c(6, 8, this.LXu) + g.a.a.b.b.a.bu(7, this.KZh);
      paramInt = i;
      if (this.LXv != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LXv);
      }
      i = paramInt;
      if (this.KZj != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KZj);
      }
      i += g.a.a.b.b.a.bu(10, this.LXw);
      paramInt = i;
      if (this.kea != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.kea);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.LXx);
      paramInt = i;
      if (this.LXy != null) {
        paramInt = i + g.a.a.a.nh(13, this.LXy.computeSize());
      }
      i = paramInt;
      if (this.LXz != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.LXz);
      }
      AppMethodBeat.o(32252);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LXs.clear();
        this.LXu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        if (this.LXm == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32252);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bpe localbpe = (bpe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32252);
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
            localbpe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpe.LXm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 3: 
          localbpe.LXr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32252);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpe.LXs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 5: 
          localbpe.LXt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32252);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpe.LXu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 7: 
          localbpe.KZh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32252);
          return 0;
        case 8: 
          localbpe.LXv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 9: 
          localbpe.KZj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 10: 
          localbpe.LXw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32252);
          return 0;
        case 11: 
          localbpe.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 12: 
          localbpe.LXx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32252);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpe.LXy = ((chk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        }
        localbpe.LXz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32252);
        return 0;
      }
      AppMethodBeat.o(32252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpe
 * JD-Core Version:    0.7.0.1
 */