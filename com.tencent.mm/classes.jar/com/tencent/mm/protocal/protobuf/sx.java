package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sx
  extends cqk
{
  public String BsL;
  public cma EmH;
  public boolean EmY;
  public String EmZ;
  public int Ena;
  public LinkedList<Integer> Enb;
  public String Enc;
  public int End;
  public int Ene;
  public int dae;
  public String desc;
  public String nWi;
  public String nyq;
  public String oxf;
  public String wJR;
  
  public sx()
  {
    AppMethodBeat.i(72433);
    this.Enb = new LinkedList();
    AppMethodBeat.o(72433);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72434);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      paramVarArgs.bl(4, this.EmY);
      if (this.wJR != null) {
        paramVarArgs.d(5, this.wJR);
      }
      if (this.EmZ != null) {
        paramVarArgs.d(6, this.EmZ);
      }
      if (this.nyq != null) {
        paramVarArgs.d(7, this.nyq);
      }
      paramVarArgs.aR(8, this.Ena);
      if (this.desc != null) {
        paramVarArgs.d(9, this.desc);
      }
      if (this.BsL != null) {
        paramVarArgs.d(10, this.BsL);
      }
      paramVarArgs.e(11, 2, this.Enb);
      if (this.Enc != null) {
        paramVarArgs.d(12, this.Enc);
      }
      if (this.nWi != null) {
        paramVarArgs.d(13, this.nWi);
      }
      paramVarArgs.aR(14, this.End);
      paramVarArgs.aR(15, this.Ene);
      if (this.EmH != null)
      {
        paramVarArgs.ln(16, this.EmH.computeSize());
        this.EmH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1293;
      }
    }
    label1293:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt + (f.a.a.b.b.a.fK(4) + 1);
      paramInt = i;
      if (this.wJR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wJR);
      }
      i = paramInt;
      if (this.EmZ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EmZ);
      }
      paramInt = i;
      if (this.nyq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nyq);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.Ena);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.desc);
      }
      i = paramInt;
      if (this.BsL != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.BsL);
      }
      i += f.a.a.a.c(11, 2, this.Enb);
      paramInt = i;
      if (this.Enc != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Enc);
      }
      i = paramInt;
      if (this.nWi != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.nWi);
      }
      i = i + f.a.a.b.b.a.bx(14, this.End) + f.a.a.b.b.a.bx(15, this.Ene);
      paramInt = i;
      if (this.EmH != null) {
        paramInt = i + f.a.a.a.lm(16, this.EmH.computeSize());
      }
      AppMethodBeat.o(72434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Enb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72434);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sx localsx = (sx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72434);
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
            localsx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72434);
          return 0;
        case 2: 
          localsx.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72434);
          return 0;
        case 3: 
          localsx.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 4: 
          localsx.EmY = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(72434);
          return 0;
        case 5: 
          localsx.wJR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 6: 
          localsx.EmZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 7: 
          localsx.nyq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 8: 
          localsx.Ena = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72434);
          return 0;
        case 9: 
          localsx.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 10: 
          localsx.BsL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 11: 
          localsx.Enb.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(72434);
          return 0;
        case 12: 
          localsx.Enc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 13: 
          localsx.nWi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 14: 
          localsx.End = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72434);
          return 0;
        case 15: 
          localsx.Ene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72434);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cma();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cma)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsx.EmH = ((cma)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      AppMethodBeat.o(72434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sx
 * JD-Core Version:    0.7.0.1
 */