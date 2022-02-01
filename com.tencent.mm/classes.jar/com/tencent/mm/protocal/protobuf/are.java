package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class are
  extends cvc
{
  public alk Glv;
  public String dwW;
  public int offset;
  public String query;
  public b sbF;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.query != null) {
        paramVarArgs.d(2, this.query);
      }
      paramVarArgs.aS(3, this.offset);
      if (this.sbF != null) {
        paramVarArgs.c(4, this.sbF);
      }
      paramVarArgs.aS(5, this.scene);
      if (this.dwW != null) {
        paramVarArgs.d(6, this.dwW);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(7, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.query);
      }
      i += f.a.a.b.b.a.bz(3, this.offset);
      paramInt = i;
      if (this.sbF != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.sbF);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.scene);
      paramInt = i;
      if (this.dwW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dwW);
      }
      i = paramInt;
      if (this.Glv != null) {
        i = paramInt + f.a.a.a.lB(7, this.Glv.computeSize());
      }
      AppMethodBeat.o(169048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        are localare = (are)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169048);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localare.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169048);
          return 0;
        case 2: 
          localare.query = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169048);
          return 0;
        case 3: 
          localare.offset = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169048);
          return 0;
        case 4: 
          localare.sbF = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(169048);
          return 0;
        case 5: 
          localare.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169048);
          return 0;
        case 6: 
          localare.dwW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169048);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localare.Glv = ((alk)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.are
 * JD-Core Version:    0.7.0.1
 */