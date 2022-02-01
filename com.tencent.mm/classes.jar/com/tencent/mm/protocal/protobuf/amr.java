package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class amr
  extends cvw
{
  public alw GDR;
  public b GER;
  public amj GES;
  public int GEU;
  public int GEV;
  public String hGI;
  public String nickname;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.GER != null) {
        paramVarArgs.c(3, this.GER);
      }
      if (this.hGI != null) {
        paramVarArgs.d(4, this.hGI);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(5, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      if (this.signature != null) {
        paramVarArgs.d(6, this.signature);
      }
      if (this.GES != null)
      {
        paramVarArgs.lJ(7, this.GES.computeSize());
        this.GES.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.GEU);
      paramVarArgs.aS(9, this.GEV);
      AppMethodBeat.o(168948);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label958;
      }
    }
    label958:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.GER != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GER);
      }
      paramInt = i;
      if (this.hGI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hGI);
      }
      i = paramInt;
      if (this.GDR != null) {
        i = paramInt + f.a.a.a.lI(5, this.GDR.computeSize());
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.signature);
      }
      i = paramInt;
      if (this.GES != null) {
        i = paramInt + f.a.a.a.lI(7, this.GES.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(8, this.GEU);
      int j = f.a.a.b.b.a.bz(9, this.GEV);
      AppMethodBeat.o(168948);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168948);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amr localamr = (amr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168948);
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
            localamr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 2: 
          localamr.nickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 3: 
          localamr.GER = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168948);
          return 0;
        case 4: 
          localamr.hGI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamr.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 6: 
          localamr.signature = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamr.GES = ((amj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 8: 
          localamr.GEU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168948);
          return 0;
        }
        localamr.GEV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168948);
        return 0;
      }
      AppMethodBeat.o(168948);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amr
 * JD-Core Version:    0.7.0.1
 */