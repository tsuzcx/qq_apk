package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmt
  extends cvc
{
  public String Hga;
  public String Hgb;
  public String Hgc;
  public String Hgd;
  public String Hge;
  public int Hgf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hga != null) {
        paramVarArgs.d(2, this.Hga);
      }
      if (this.Hgb != null) {
        paramVarArgs.d(3, this.Hgb);
      }
      if (this.Hgc != null) {
        paramVarArgs.d(4, this.Hgc);
      }
      if (this.Hgd != null) {
        paramVarArgs.d(5, this.Hgd);
      }
      if (this.Hge != null) {
        paramVarArgs.d(6, this.Hge);
      }
      paramVarArgs.aS(7, this.Hgf);
      AppMethodBeat.o(32374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label671;
      }
    }
    label671:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hga != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hga);
      }
      i = paramInt;
      if (this.Hgb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hgb);
      }
      paramInt = i;
      if (this.Hgc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hgc);
      }
      i = paramInt;
      if (this.Hgd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hgd);
      }
      paramInt = i;
      if (this.Hge != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hge);
      }
      i = f.a.a.b.b.a.bz(7, this.Hgf);
      AppMethodBeat.o(32374);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmt localcmt = (cmt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32374);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32374);
          return 0;
        case 2: 
          localcmt.Hga = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 3: 
          localcmt.Hgb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 4: 
          localcmt.Hgc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 5: 
          localcmt.Hgd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 6: 
          localcmt.Hge = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32374);
          return 0;
        }
        localcmt.Hgf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32374);
        return 0;
      }
      AppMethodBeat.o(32374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmt
 * JD-Core Version:    0.7.0.1
 */