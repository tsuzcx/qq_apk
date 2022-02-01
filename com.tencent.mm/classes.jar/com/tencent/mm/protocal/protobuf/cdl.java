package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdl
  extends cpx
{
  public String EJP;
  public bb EhT;
  public String EpT;
  public String EpU;
  public String EpV;
  public String EpW;
  public String Fsh;
  public String Fsi;
  public String Fsj;
  public String Fsk;
  public String Fsl;
  public String hOf;
  public String thr;
  public String tkL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91571);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      if (this.Fsh != null) {
        paramVarArgs.d(3, this.Fsh);
      }
      if (this.EJP != null) {
        paramVarArgs.d(4, this.EJP);
      }
      if (this.EpT != null) {
        paramVarArgs.d(5, this.EpT);
      }
      if (this.Fsi != null) {
        paramVarArgs.d(6, this.Fsi);
      }
      if (this.EpU != null) {
        paramVarArgs.d(7, this.EpU);
      }
      if (this.EpV != null) {
        paramVarArgs.d(8, this.EpV);
      }
      if (this.EpW != null) {
        paramVarArgs.d(9, this.EpW);
      }
      if (this.Fsj != null) {
        paramVarArgs.d(10, this.Fsj);
      }
      if (this.EhT != null)
      {
        paramVarArgs.ln(11, this.EhT.computeSize());
        this.EhT.writeFields(paramVarArgs);
      }
      if (this.Fsk != null) {
        paramVarArgs.d(12, this.Fsk);
      }
      if (this.thr != null) {
        paramVarArgs.d(13, this.thr);
      }
      if (this.tkL != null) {
        paramVarArgs.d(14, this.tkL);
      }
      if (this.Fsl != null) {
        paramVarArgs.d(15, this.Fsl);
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
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt;
      if (this.Fsh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fsh);
      }
      paramInt = i;
      if (this.EJP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EJP);
      }
      i = paramInt;
      if (this.EpT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EpT);
      }
      paramInt = i;
      if (this.Fsi != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fsi);
      }
      i = paramInt;
      if (this.EpU != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EpU);
      }
      paramInt = i;
      if (this.EpV != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EpV);
      }
      i = paramInt;
      if (this.EpW != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EpW);
      }
      paramInt = i;
      if (this.Fsj != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Fsj);
      }
      i = paramInt;
      if (this.EhT != null) {
        i = paramInt + f.a.a.a.lm(11, this.EhT.computeSize());
      }
      paramInt = i;
      if (this.Fsk != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fsk);
      }
      i = paramInt;
      if (this.thr != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.thr);
      }
      paramInt = i;
      if (this.tkL != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.tkL);
      }
      i = paramInt;
      if (this.Fsl != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Fsl);
      }
      AppMethodBeat.o(91571);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdl localcdl = (cdl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91571);
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
            localcdl.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 2: 
          localcdl.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 3: 
          localcdl.Fsh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 4: 
          localcdl.EJP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 5: 
          localcdl.EpT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 6: 
          localcdl.Fsi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 7: 
          localcdl.EpU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 8: 
          localcdl.EpV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 9: 
          localcdl.EpW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 10: 
          localcdl.Fsj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdl.EhT = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 12: 
          localcdl.Fsk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 13: 
          localcdl.thr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 14: 
          localcdl.tkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91571);
          return 0;
        }
        localcdl.Fsl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91571);
        return 0;
      }
      AppMethodBeat.o(91571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdl
 * JD-Core Version:    0.7.0.1
 */