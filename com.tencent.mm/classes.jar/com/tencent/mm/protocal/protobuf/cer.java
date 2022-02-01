package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class cer
  extends dpc
{
  public String KCL;
  public String KCy;
  public cdz Mkb;
  public String Mkl;
  public String Mkm;
  public String Mkn;
  public int Mko;
  public String keb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123613);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123613);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Mkb != null)
      {
        paramVarArgs.ni(2, this.Mkb.computeSize());
        this.Mkb.writeFields(paramVarArgs);
      }
      if (this.Mkm != null) {
        paramVarArgs.e(3, this.Mkm);
      }
      if (this.KCL != null) {
        paramVarArgs.e(4, this.KCL);
      }
      if (this.KCy != null) {
        paramVarArgs.e(5, this.KCy);
      }
      if (this.Mkn != null) {
        paramVarArgs.e(6, this.Mkn);
      }
      paramVarArgs.aM(7, this.Mko);
      if (this.Mkl != null) {
        paramVarArgs.e(8, this.Mkl);
      }
      if (this.keb != null) {
        paramVarArgs.e(9, this.keb);
      }
      AppMethodBeat.o(123613);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mkb != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mkb.computeSize());
      }
      i = paramInt;
      if (this.Mkm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mkm);
      }
      paramInt = i;
      if (this.KCL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KCL);
      }
      i = paramInt;
      if (this.KCy != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KCy);
      }
      paramInt = i;
      if (this.Mkn != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mkn);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.Mko);
      paramInt = i;
      if (this.Mkl != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mkl);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.keb);
      }
      AppMethodBeat.o(123613);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123613);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123613);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cer localcer = (cer)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123613);
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
            localcer.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcer.Mkb = ((cdz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 3: 
          localcer.Mkm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 4: 
          localcer.KCL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 5: 
          localcer.KCy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 6: 
          localcer.Mkn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 7: 
          localcer.Mko = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123613);
          return 0;
        case 8: 
          localcer.Mkl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123613);
          return 0;
        }
        localcer.keb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123613);
        return 0;
      }
      AppMethodBeat.o(123613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cer
 * JD-Core Version:    0.7.0.1
 */