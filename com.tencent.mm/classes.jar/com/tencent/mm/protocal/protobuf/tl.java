package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tl
  extends com.tencent.mm.bw.a
{
  public dnl FLn;
  public cxk FLp;
  public String FUn;
  public int GjA;
  public int GjB;
  public bqg Gjy;
  public LinkedList<dnl> Gjz;
  public String dlT;
  public int state;
  public String wRt;
  
  public tl()
  {
    AppMethodBeat.i(91394);
    this.Gjz = new LinkedList();
    AppMethodBeat.o(91394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gjy != null)
      {
        paramVarArgs.lJ(1, this.Gjy.computeSize());
        this.Gjy.writeFields(paramVarArgs);
      }
      if (this.FLn != null)
      {
        paramVarArgs.lJ(2, this.FLn.computeSize());
        this.FLn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Gjz);
      if (this.wRt != null) {
        paramVarArgs.d(4, this.wRt);
      }
      if (this.dlT != null) {
        paramVarArgs.d(5, this.dlT);
      }
      if (this.FLp != null)
      {
        paramVarArgs.lJ(6, this.FLp.computeSize());
        this.FLp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.state);
      paramVarArgs.aS(8, this.GjA);
      paramVarArgs.aS(9, this.GjB);
      if (this.FUn != null) {
        paramVarArgs.d(10, this.FUn);
      }
      AppMethodBeat.o(91395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gjy == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.lI(1, this.Gjy.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FLn != null) {
        i = paramInt + f.a.a.a.lI(2, this.FLn.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.Gjz);
      paramInt = i;
      if (this.wRt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wRt);
      }
      i = paramInt;
      if (this.dlT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dlT);
      }
      paramInt = i;
      if (this.FLp != null) {
        paramInt = i + f.a.a.a.lI(6, this.FLp.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.state) + f.a.a.b.b.a.bz(8, this.GjA) + f.a.a.b.b.a.bz(9, this.GjB);
      paramInt = i;
      if (this.FUn != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FUn);
      }
      AppMethodBeat.o(91395);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gjz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tl localtl = (tl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91395);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtl.Gjy = ((bqg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtl.FLn = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtl.Gjz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 4: 
          localtl.wRt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 5: 
          localtl.dlT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtl.FLp = ((cxk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 7: 
          localtl.state = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91395);
          return 0;
        case 8: 
          localtl.GjA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91395);
          return 0;
        case 9: 
          localtl.GjB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91395);
          return 0;
        }
        localtl.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91395);
        return 0;
      }
      AppMethodBeat.o(91395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tl
 * JD-Core Version:    0.7.0.1
 */