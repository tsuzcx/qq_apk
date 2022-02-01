package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ym
  extends cvw
{
  public String Gdc;
  public dya Gqr;
  public int Scene;
  public String uvF;
  public String uvG;
  public int xri;
  public long xrk;
  public int xsB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32166);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gdc != null) {
        paramVarArgs.d(2, this.Gdc);
      }
      paramVarArgs.aS(3, this.xsB);
      paramVarArgs.aS(4, this.xri);
      if (this.Gqr != null)
      {
        paramVarArgs.lJ(5, this.Gqr.computeSize());
        this.Gqr.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.xrk);
      paramVarArgs.aS(7, this.Scene);
      if (this.uvG != null) {
        paramVarArgs.d(8, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(9, this.uvF);
      }
      AppMethodBeat.o(32166);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label841;
      }
    }
    label841:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gdc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gdc);
      }
      i = i + f.a.a.b.b.a.bz(3, this.xsB) + f.a.a.b.b.a.bz(4, this.xri);
      paramInt = i;
      if (this.Gqr != null) {
        paramInt = i + f.a.a.a.lI(5, this.Gqr.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.xrk) + f.a.a.b.b.a.bz(7, this.Scene);
      paramInt = i;
      if (this.uvG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.uvG);
      }
      i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.uvF);
      }
      AppMethodBeat.o(32166);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32166);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ym localym = (ym)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32166);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localym.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 2: 
          localym.Gdc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32166);
          return 0;
        case 3: 
          localym.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32166);
          return 0;
        case 4: 
          localym.xri = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32166);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dya();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dya)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localym.Gqr = ((dya)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 6: 
          localym.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32166);
          return 0;
        case 7: 
          localym.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32166);
          return 0;
        case 8: 
          localym.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32166);
          return 0;
        }
        localym.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32166);
        return 0;
      }
      AppMethodBeat.o(32166);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ym
 * JD-Core Version:    0.7.0.1
 */