package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class art
  extends cvw
{
  public alw GDR;
  public String dyb;
  public int offset;
  public String query;
  public int scene;
  public b skw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.query != null) {
        paramVarArgs.d(2, this.query);
      }
      paramVarArgs.aS(3, this.offset);
      if (this.skw != null) {
        paramVarArgs.c(4, this.skw);
      }
      paramVarArgs.aS(5, this.scene);
      if (this.dyb != null) {
        paramVarArgs.d(6, this.dyb);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(7, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.query);
      }
      i += f.a.a.b.b.a.bz(3, this.offset);
      paramInt = i;
      if (this.skw != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.skw);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.scene);
      paramInt = i;
      if (this.dyb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dyb);
      }
      i = paramInt;
      if (this.GDR != null) {
        i = paramInt + f.a.a.a.lI(7, this.GDR.computeSize());
      }
      AppMethodBeat.o(169048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        art localart = (art)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169048);
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
            localart.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169048);
          return 0;
        case 2: 
          localart.query = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169048);
          return 0;
        case 3: 
          localart.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169048);
          return 0;
        case 4: 
          localart.skw = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(169048);
          return 0;
        case 5: 
          localart.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169048);
          return 0;
        case 6: 
          localart.dyb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169048);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localart.GDR = ((alw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169048);
        return 0;
      }
      AppMethodBeat.o(169048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.art
 * JD-Core Version:    0.7.0.1
 */