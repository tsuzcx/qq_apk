package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uu
  extends ckq
{
  public String CWD;
  public String CWE;
  public String CWF;
  public String CWG;
  public String CWH;
  public long CWI;
  public String CWJ;
  public String CWK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32161);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CWD != null) {
        paramVarArgs.d(2, this.CWD);
      }
      if (this.CWE != null) {
        paramVarArgs.d(3, this.CWE);
      }
      if (this.CWF != null) {
        paramVarArgs.d(4, this.CWF);
      }
      if (this.CWG != null) {
        paramVarArgs.d(5, this.CWG);
      }
      if (this.CWH != null) {
        paramVarArgs.d(6, this.CWH);
      }
      paramVarArgs.aG(7, this.CWI);
      if (this.CWJ != null) {
        paramVarArgs.d(8, this.CWJ);
      }
      if (this.CWK != null) {
        paramVarArgs.d(9, this.CWK);
      }
      AppMethodBeat.o(32161);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label797;
      }
    }
    label797:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CWD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CWD);
      }
      i = paramInt;
      if (this.CWE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CWE);
      }
      paramInt = i;
      if (this.CWF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CWF);
      }
      i = paramInt;
      if (this.CWG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CWG);
      }
      paramInt = i;
      if (this.CWH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CWH);
      }
      i = paramInt + f.a.a.b.b.a.q(7, this.CWI);
      paramInt = i;
      if (this.CWJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CWJ);
      }
      i = paramInt;
      if (this.CWK != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CWK);
      }
      AppMethodBeat.o(32161);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32161);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uu localuu = (uu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32161);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuu.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32161);
          return 0;
        case 2: 
          localuu.CWD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 3: 
          localuu.CWE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 4: 
          localuu.CWF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 5: 
          localuu.CWG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 6: 
          localuu.CWH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 7: 
          localuu.CWI = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32161);
          return 0;
        case 8: 
          localuu.CWJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32161);
          return 0;
        }
        localuu.CWK = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32161);
        return 0;
      }
      AppMethodBeat.o(32161);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uu
 * JD-Core Version:    0.7.0.1
 */