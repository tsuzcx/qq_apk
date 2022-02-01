package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvg
  extends com.tencent.mm.bx.a
{
  public int DSs;
  public bvh DSt;
  public int DSu;
  public int DSv;
  public int DSw;
  public int DSx;
  public int Dwk;
  public bvi Dwl;
  public String app_id;
  public String hNI;
  public int tyA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152631);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hNI != null) {
        paramVarArgs.d(1, this.hNI);
      }
      paramVarArgs.aR(2, this.DSs);
      if (this.DSt != null)
      {
        paramVarArgs.kX(3, this.DSt.computeSize());
        this.DSt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Dwk);
      if (this.Dwl != null)
      {
        paramVarArgs.kX(5, this.Dwl.computeSize());
        this.Dwl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.DSu);
      paramVarArgs.aR(7, this.DSv);
      paramVarArgs.aR(8, this.tyA);
      paramVarArgs.aR(9, this.DSw);
      if (this.app_id != null) {
        paramVarArgs.d(10, this.app_id);
      }
      paramVarArgs.aR(11, this.DSx);
      AppMethodBeat.o(152631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hNI == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = f.a.a.b.b.a.e(1, this.hNI) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DSs);
      paramInt = i;
      if (this.DSt != null) {
        paramInt = i + f.a.a.a.kW(3, this.DSt.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Dwk);
      paramInt = i;
      if (this.Dwl != null) {
        paramInt = i + f.a.a.a.kW(5, this.Dwl.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.DSu) + f.a.a.b.b.a.bA(7, this.DSv) + f.a.a.b.b.a.bA(8, this.tyA) + f.a.a.b.b.a.bA(9, this.DSw);
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.app_id);
      }
      i = f.a.a.b.b.a.bA(11, this.DSx);
      AppMethodBeat.o(152631);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvg localbvg = (bvg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152631);
          return -1;
        case 1: 
          localbvg.hNI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152631);
          return 0;
        case 2: 
          localbvg.DSs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152631);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvg.DSt = ((bvh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 4: 
          localbvg.Dwk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152631);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvg.Dwl = ((bvi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 6: 
          localbvg.DSu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152631);
          return 0;
        case 7: 
          localbvg.DSv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152631);
          return 0;
        case 8: 
          localbvg.tyA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152631);
          return 0;
        case 9: 
          localbvg.DSw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152631);
          return 0;
        case 10: 
          localbvg.app_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152631);
          return 0;
        }
        localbvg.DSx = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152631);
        return 0;
      }
      AppMethodBeat.o(152631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvg
 * JD-Core Version:    0.7.0.1
 */