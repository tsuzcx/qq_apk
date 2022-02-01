package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class als
  extends cvw
{
  public String GDP;
  public int GDQ;
  public alw GDR;
  public alz GDS;
  public long GDT;
  public String firstPageMD5;
  public b lastBuffer;
  public String sef;
  public String username;
  public int vGk;
  public long zxX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189300);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aZ(3, this.zxX);
      if (this.firstPageMD5 != null) {
        paramVarArgs.d(4, this.firstPageMD5);
      }
      if (this.GDP != null) {
        paramVarArgs.d(5, this.GDP);
      }
      paramVarArgs.aS(6, this.GDQ);
      if (this.GDR != null)
      {
        paramVarArgs.lJ(7, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(8, this.lastBuffer);
      }
      paramVarArgs.aS(9, this.vGk);
      if (this.GDS != null)
      {
        paramVarArgs.lJ(10, this.GDS.computeSize());
        this.GDS.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(11, this.GDT);
      if (this.sef != null) {
        paramVarArgs.d(12, this.sef);
      }
      AppMethodBeat.o(189300);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1110;
      }
    }
    label1110:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i += f.a.a.b.b.a.p(3, this.zxX);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.firstPageMD5);
      }
      i = paramInt;
      if (this.GDP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GDP);
      }
      i += f.a.a.b.b.a.bz(6, this.GDQ);
      paramInt = i;
      if (this.GDR != null) {
        paramInt = i + f.a.a.a.lI(7, this.GDR.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(8, this.lastBuffer);
      }
      i += f.a.a.b.b.a.bz(9, this.vGk);
      paramInt = i;
      if (this.GDS != null) {
        paramInt = i + f.a.a.a.lI(10, this.GDS.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(11, this.GDT);
      paramInt = i;
      if (this.sef != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.sef);
      }
      AppMethodBeat.o(189300);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189300);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        als localals = (als)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189300);
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
            localals.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189300);
          return 0;
        case 2: 
          localals.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189300);
          return 0;
        case 3: 
          localals.zxX = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(189300);
          return 0;
        case 4: 
          localals.firstPageMD5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189300);
          return 0;
        case 5: 
          localals.GDP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189300);
          return 0;
        case 6: 
          localals.GDQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189300);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localals.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189300);
          return 0;
        case 8: 
          localals.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(189300);
          return 0;
        case 9: 
          localals.vGk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189300);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localals.GDS = ((alz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189300);
          return 0;
        case 11: 
          localals.GDT = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(189300);
          return 0;
        }
        localals.sef = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189300);
        return 0;
      }
      AppMethodBeat.o(189300);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.als
 * JD-Core Version:    0.7.0.1
 */