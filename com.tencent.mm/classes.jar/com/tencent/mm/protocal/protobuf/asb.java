package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asb
  extends cvw
{
  public alw GDR;
  public alz GDS;
  public LinkedList<dje> GIA;
  public long LGt;
  public String sbR;
  
  public asb()
  {
    AppMethodBeat.i(169053);
    this.GIA = new LinkedList();
    AppMethodBeat.o(169053);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169054);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GIA);
      if (this.sbR != null) {
        paramVarArgs.d(3, this.sbR);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(4, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      if (this.GDS != null)
      {
        paramVarArgs.lJ(5, this.GDS.computeSize());
        this.GDS.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(7, this.LGt);
      AppMethodBeat.o(169054);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label870;
      }
    }
    label870:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GIA);
      paramInt = i;
      if (this.sbR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.sbR);
      }
      i = paramInt;
      if (this.GDR != null) {
        i = paramInt + f.a.a.a.lI(4, this.GDR.computeSize());
      }
      paramInt = i;
      if (this.GDS != null) {
        paramInt = i + f.a.a.a.lI(5, this.GDS.computeSize());
      }
      i = f.a.a.b.b.a.p(7, this.LGt);
      AppMethodBeat.o(169054);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GIA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169054);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asb localasb = (asb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(169054);
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
            localasb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dje();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dje)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasb.GIA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 3: 
          localasb.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169054);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasb.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasb.GDS = ((alz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        }
        localasb.LGt = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169054);
        return 0;
      }
      AppMethodBeat.o(169054);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asb
 * JD-Core Version:    0.7.0.1
 */