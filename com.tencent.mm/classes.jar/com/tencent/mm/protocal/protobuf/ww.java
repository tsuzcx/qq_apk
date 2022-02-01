package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ww
  extends cpx
{
  public String DPY;
  public int DZA;
  public String EaV;
  public int Erj;
  public String Erk;
  public LinkedList<wv> Erl;
  public cwb Erm;
  public cxh Ern;
  public int scene;
  
  public ww()
  {
    AppMethodBeat.i(124474);
    this.Erl = new LinkedList();
    AppMethodBeat.o(124474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Erj);
      if (this.Erk != null) {
        paramVarArgs.d(3, this.Erk);
      }
      if (this.EaV != null) {
        paramVarArgs.d(4, this.EaV);
      }
      if (this.DPY != null) {
        paramVarArgs.d(5, this.DPY);
      }
      paramVarArgs.e(6, 8, this.Erl);
      paramVarArgs.aR(7, this.scene);
      paramVarArgs.aR(8, this.DZA);
      if (this.Erm != null)
      {
        paramVarArgs.ln(9, this.Erm.computeSize());
        this.Erm.writeFields(paramVarArgs);
      }
      if (this.Ern != null)
      {
        paramVarArgs.ln(10, this.Ern.computeSize());
        this.Ern.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Erj);
      paramInt = i;
      if (this.Erk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Erk);
      }
      i = paramInt;
      if (this.EaV != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EaV);
      }
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DPY);
      }
      i = paramInt + f.a.a.a.c(6, 8, this.Erl) + f.a.a.b.b.a.bx(7, this.scene) + f.a.a.b.b.a.bx(8, this.DZA);
      paramInt = i;
      if (this.Erm != null) {
        paramInt = i + f.a.a.a.lm(9, this.Erm.computeSize());
      }
      i = paramInt;
      if (this.Ern != null) {
        i = paramInt + f.a.a.a.lm(10, this.Ern.computeSize());
      }
      AppMethodBeat.o(124475);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Erl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ww localww = (ww)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124475);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localww.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 2: 
          localww.Erj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124475);
          return 0;
        case 3: 
          localww.Erk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 4: 
          localww.EaV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 5: 
          localww.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localww.Erl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 7: 
          localww.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124475);
          return 0;
        case 8: 
          localww.DZA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124475);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localww.Erm = ((cwb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localww.Ern = ((cxh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      AppMethodBeat.o(124475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ww
 * JD-Core Version:    0.7.0.1
 */