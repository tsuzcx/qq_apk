package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efv
  extends cvw
{
  public String IgN;
  public int IjA;
  public String IjB;
  public String IjC;
  public String Ijw;
  public int Ijx;
  public int Ijy;
  public String Ijz;
  public String dwb;
  public String dxe;
  public String oqi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dxe != null) {
        paramVarArgs.d(2, this.dxe);
      }
      if (this.Ijw != null) {
        paramVarArgs.d(3, this.Ijw);
      }
      paramVarArgs.aS(4, this.Ijx);
      paramVarArgs.aS(5, this.Ijy);
      if (this.IgN != null) {
        paramVarArgs.d(6, this.IgN);
      }
      if (this.oqi != null) {
        paramVarArgs.d(7, this.oqi);
      }
      if (this.dwb != null) {
        paramVarArgs.d(8, this.dwb);
      }
      if (this.Ijz != null) {
        paramVarArgs.d(9, this.Ijz);
      }
      paramVarArgs.aS(10, this.IjA);
      if (this.IjB != null) {
        paramVarArgs.d(11, this.IjB);
      }
      if (this.IjC != null) {
        paramVarArgs.d(12, this.IjC);
      }
      AppMethodBeat.o(82489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label934;
      }
    }
    label934:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dxe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxe);
      }
      i = paramInt;
      if (this.Ijw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ijw);
      }
      i = i + f.a.a.b.b.a.bz(4, this.Ijx) + f.a.a.b.b.a.bz(5, this.Ijy);
      paramInt = i;
      if (this.IgN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.IgN);
      }
      i = paramInt;
      if (this.oqi != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.oqi);
      }
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dwb);
      }
      i = paramInt;
      if (this.Ijz != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ijz);
      }
      i += f.a.a.b.b.a.bz(10, this.IjA);
      paramInt = i;
      if (this.IjB != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.IjB);
      }
      i = paramInt;
      if (this.IjC != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.IjC);
      }
      AppMethodBeat.o(82489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        efv localefv = (efv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82489);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localefv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82489);
          return 0;
        case 2: 
          localefv.dxe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 3: 
          localefv.Ijw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 4: 
          localefv.Ijx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82489);
          return 0;
        case 5: 
          localefv.Ijy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82489);
          return 0;
        case 6: 
          localefv.IgN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 7: 
          localefv.oqi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 8: 
          localefv.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 9: 
          localefv.Ijz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 10: 
          localefv.IjA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82489);
          return 0;
        case 11: 
          localefv.IjB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82489);
          return 0;
        }
        localefv.IjC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82489);
        return 0;
      }
      AppMethodBeat.o(82489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efv
 * JD-Core Version:    0.7.0.1
 */