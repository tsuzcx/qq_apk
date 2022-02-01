package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzf
  extends cqk
{
  public String AYl;
  public boolean FdJ;
  public brl FnZ;
  public String Foa;
  public agt Fob;
  public int Foc;
  public int Fod;
  public int Foe;
  public LinkedList<acz> Fof;
  public LinkedList<cnj> Fog;
  public LinkedList<il> Foh;
  public cga Foi;
  public int Foj;
  public int nWx;
  public String nWy;
  
  public bzf()
  {
    AppMethodBeat.i(91561);
    this.Fof = new LinkedList();
    this.Fog = new LinkedList();
    this.Foh = new LinkedList();
    AppMethodBeat.o(91561);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      paramVarArgs.aR(4, this.Foc);
      paramVarArgs.aR(5, this.Fod);
      paramVarArgs.aR(6, this.Foe);
      paramVarArgs.e(8, 8, this.Fof);
      if (this.FnZ != null)
      {
        paramVarArgs.ln(9, this.FnZ.computeSize());
        this.FnZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.Fog);
      paramVarArgs.e(11, 8, this.Foh);
      paramVarArgs.bl(12, this.FdJ);
      if (this.Foi != null)
      {
        paramVarArgs.ln(13, this.Foi.computeSize());
        this.Foi.writeFields(paramVarArgs);
      }
      if (this.Foa != null) {
        paramVarArgs.d(14, this.Foa);
      }
      if (this.Fob != null)
      {
        paramVarArgs.ln(15, this.Fob.computeSize());
        this.Fob.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(16, this.Foj);
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(91562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1754;
      }
    }
    label1754:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Foc) + f.a.a.b.b.a.bx(5, this.Fod) + f.a.a.b.b.a.bx(6, this.Foe) + f.a.a.a.c(8, 8, this.Fof);
      paramInt = i;
      if (this.FnZ != null) {
        paramInt = i + f.a.a.a.lm(9, this.FnZ.computeSize());
      }
      i = paramInt + f.a.a.a.c(10, 8, this.Fog) + f.a.a.a.c(11, 8, this.Foh) + (f.a.a.b.b.a.fK(12) + 1);
      paramInt = i;
      if (this.Foi != null) {
        paramInt = i + f.a.a.a.lm(13, this.Foi.computeSize());
      }
      i = paramInt;
      if (this.Foa != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Foa);
      }
      paramInt = i;
      if (this.Fob != null) {
        paramInt = i + f.a.a.a.lm(15, this.Fob.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.Foj);
      paramInt = i;
      if (this.AYl != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(91562);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fof.clear();
        this.Fog.clear();
        this.Foh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzf localbzf = (bzf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91562);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 2: 
          localbzf.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91562);
          return 0;
        case 3: 
          localbzf.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 4: 
          localbzf.Foc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91562);
          return 0;
        case 5: 
          localbzf.Fod = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91562);
          return 0;
        case 6: 
          localbzf.Foe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91562);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzf.Fof.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzf.FnZ = ((brl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzf.Fog.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new il();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((il)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzf.Foh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 12: 
          localbzf.FdJ = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91562);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cga();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cga)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzf.Foi = ((cga)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 14: 
          localbzf.Foa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzf.Fob = ((agt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 16: 
          localbzf.Foj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91562);
          return 0;
        }
        localbzf.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91562);
        return 0;
      }
      AppMethodBeat.o(91562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzf
 * JD-Core Version:    0.7.0.1
 */