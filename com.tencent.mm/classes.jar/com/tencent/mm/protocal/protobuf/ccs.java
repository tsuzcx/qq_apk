package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccs
  extends com.tencent.mm.bv.a
{
  public String AesKey;
  public String Md5;
  public int Scene;
  public String wqN;
  public int wzS;
  public String xHX;
  public int xNi;
  public String xNj;
  public int xfs;
  public int xqT;
  public azu xqU;
  public String xqX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151930);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      paramVarArgs.aO(2, this.wzS);
      paramVarArgs.aO(3, this.Scene);
      if (this.xqX != null) {
        paramVarArgs.e(4, this.xqX);
      }
      if (this.wqN != null) {
        paramVarArgs.e(5, this.wqN);
      }
      paramVarArgs.aO(6, this.xqT);
      if (this.xqU != null)
      {
        paramVarArgs.iQ(7, this.xqU.computeSize());
        this.xqU.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.xNi);
      if (this.xHX != null) {
        paramVarArgs.e(9, this.xHX);
      }
      paramVarArgs.aO(10, this.xfs);
      if (this.xNj != null) {
        paramVarArgs.e(11, this.xNj);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(12, this.AesKey);
      }
      AppMethodBeat.o(151930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = e.a.a.b.b.a.f(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wzS) + e.a.a.b.b.a.bl(3, this.Scene);
      paramInt = i;
      if (this.xqX != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xqX);
      }
      i = paramInt;
      if (this.wqN != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wqN);
      }
      i += e.a.a.b.b.a.bl(6, this.xqT);
      paramInt = i;
      if (this.xqU != null) {
        paramInt = i + e.a.a.a.iP(7, this.xqU.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xNi);
      paramInt = i;
      if (this.xHX != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xHX);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.xfs);
      paramInt = i;
      if (this.xNj != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xNj);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.AesKey);
      }
      AppMethodBeat.o(151930);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151930);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ccs localccs = (ccs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151930);
          return -1;
        case 1: 
          localccs.Md5 = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151930);
          return 0;
        case 2: 
          localccs.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151930);
          return 0;
        case 3: 
          localccs.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151930);
          return 0;
        case 4: 
          localccs.xqX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151930);
          return 0;
        case 5: 
          localccs.wqN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151930);
          return 0;
        case 6: 
          localccs.xqT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151930);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((azu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localccs.xqU = ((azu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151930);
          return 0;
        case 8: 
          localccs.xNi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151930);
          return 0;
        case 9: 
          localccs.xHX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151930);
          return 0;
        case 10: 
          localccs.xfs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151930);
          return 0;
        case 11: 
          localccs.xNj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151930);
          return 0;
        }
        localccs.AesKey = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(151930);
        return 0;
      }
      AppMethodBeat.o(151930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccs
 * JD-Core Version:    0.7.0.1
 */