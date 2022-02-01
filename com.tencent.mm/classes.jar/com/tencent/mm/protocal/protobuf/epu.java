package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class epu
  extends dop
{
  public int APa;
  public String MJA;
  public int MJB;
  public String MJC;
  public String MJz;
  public SKBuiltinBuffer_t Nno;
  public int Nnp;
  public int Nnq;
  public String Nnr;
  public String ProductID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91722);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nno == null)
      {
        paramVarArgs = new b("Not all required fields were included: Receipt");
        AppMethodBeat.o(91722);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Nno != null)
      {
        paramVarArgs.ni(2, this.Nno.computeSize());
        this.Nno.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(3, this.ProductID);
      }
      paramVarArgs.aM(4, this.Nnp);
      paramVarArgs.aM(5, this.APa);
      if (this.MJz != null) {
        paramVarArgs.e(6, this.MJz);
      }
      if (this.MJA != null) {
        paramVarArgs.e(7, this.MJA);
      }
      if (this.MJC != null) {
        paramVarArgs.e(8, this.MJC);
      }
      paramVarArgs.aM(9, this.Nnq);
      if (this.Nnr != null) {
        paramVarArgs.e(10, this.Nnr);
      }
      paramVarArgs.aM(11, this.MJB);
      AppMethodBeat.o(91722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label998;
      }
    }
    label998:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nno != null) {
        paramInt = i + g.a.a.a.nh(2, this.Nno.computeSize());
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ProductID);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Nnp) + g.a.a.b.b.a.bu(5, this.APa);
      paramInt = i;
      if (this.MJz != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MJz);
      }
      i = paramInt;
      if (this.MJA != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MJA);
      }
      paramInt = i;
      if (this.MJC != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MJC);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.Nnq);
      paramInt = i;
      if (this.Nnr != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Nnr);
      }
      i = g.a.a.b.b.a.bu(11, this.MJB);
      AppMethodBeat.o(91722);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Nno == null)
        {
          paramVarArgs = new b("Not all required fields were included: Receipt");
          AppMethodBeat.o(91722);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        epu localepu = (epu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91722);
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
            localepu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localepu.Nno = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 3: 
          localepu.ProductID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 4: 
          localepu.Nnp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91722);
          return 0;
        case 5: 
          localepu.APa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91722);
          return 0;
        case 6: 
          localepu.MJz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 7: 
          localepu.MJA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 8: 
          localepu.MJC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 9: 
          localepu.Nnq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91722);
          return 0;
        case 10: 
          localepu.Nnr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91722);
          return 0;
        }
        localepu.MJB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91722);
        return 0;
      }
      AppMethodBeat.o(91722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epu
 * JD-Core Version:    0.7.0.1
 */