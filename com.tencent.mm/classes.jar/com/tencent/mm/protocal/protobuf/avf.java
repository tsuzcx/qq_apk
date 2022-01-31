package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avf
  extends com.tencent.mm.bv.a
{
  public int kmb;
  public String knv;
  public int state;
  public int tVm;
  public String wKl;
  public long wOy;
  public int wyt;
  public String xcf;
  public String xkD;
  public bme xkE;
  public int xkF;
  public int xkG;
  public String xkH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48871);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xcf != null) {
        paramVarArgs.e(1, this.xcf);
      }
      if (this.wKl != null) {
        paramVarArgs.e(2, this.wKl);
      }
      paramVarArgs.am(3, this.wOy);
      paramVarArgs.aO(4, this.state);
      if (this.xkD != null) {
        paramVarArgs.e(5, this.xkD);
      }
      paramVarArgs.aO(6, this.tVm);
      if (this.xkE != null)
      {
        paramVarArgs.iQ(7, this.xkE.computeSize());
        this.xkE.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.wyt);
      paramVarArgs.aO(9, this.kmb);
      paramVarArgs.aO(10, this.xkF);
      paramVarArgs.aO(11, this.xkG);
      if (this.xkH != null) {
        paramVarArgs.e(12, this.xkH);
      }
      if (this.knv != null) {
        paramVarArgs.e(13, this.knv);
      }
      AppMethodBeat.o(48871);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xcf == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = e.a.a.b.b.a.f(1, this.xcf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wKl != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wKl);
      }
      i = i + e.a.a.b.b.a.p(3, this.wOy) + e.a.a.b.b.a.bl(4, this.state);
      paramInt = i;
      if (this.xkD != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xkD);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.tVm);
      paramInt = i;
      if (this.xkE != null) {
        paramInt = i + e.a.a.a.iP(7, this.xkE.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.wyt) + e.a.a.b.b.a.bl(9, this.kmb) + e.a.a.b.b.a.bl(10, this.xkF) + e.a.a.b.b.a.bl(11, this.xkG);
      paramInt = i;
      if (this.xkH != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xkH);
      }
      i = paramInt;
      if (this.knv != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.knv);
      }
      AppMethodBeat.o(48871);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48871);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        avf localavf = (avf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48871);
          return -1;
        case 1: 
          localavf.xcf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48871);
          return 0;
        case 2: 
          localavf.wKl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48871);
          return 0;
        case 3: 
          localavf.wOy = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(48871);
          return 0;
        case 4: 
          localavf.state = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48871);
          return 0;
        case 5: 
          localavf.xkD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48871);
          return 0;
        case 6: 
          localavf.tVm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48871);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bme();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bme)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localavf.xkE = ((bme)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48871);
          return 0;
        case 8: 
          localavf.wyt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48871);
          return 0;
        case 9: 
          localavf.kmb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48871);
          return 0;
        case 10: 
          localavf.xkF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48871);
          return 0;
        case 11: 
          localavf.xkG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48871);
          return 0;
        case 12: 
          localavf.xkH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48871);
          return 0;
        }
        localavf.knv = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48871);
        return 0;
      }
      AppMethodBeat.o(48871);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avf
 * JD-Core Version:    0.7.0.1
 */