package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class amf
  extends cvc
{
  public b GlQ;
  public alx GlR;
  public int GlS;
  public int GlT;
  public alk Glv;
  public String hDQ;
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
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.GlQ != null) {
        paramVarArgs.c(3, this.GlQ);
      }
      if (this.hDQ != null) {
        paramVarArgs.d(4, this.hDQ);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(5, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      if (this.signature != null) {
        paramVarArgs.d(6, this.signature);
      }
      if (this.GlR != null)
      {
        paramVarArgs.lC(7, this.GlR.computeSize());
        this.GlR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.GlS);
      paramVarArgs.aS(9, this.GlT);
      AppMethodBeat.o(168948);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label958;
      }
    }
    label958:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.GlQ != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GlQ);
      }
      paramInt = i;
      if (this.hDQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hDQ);
      }
      i = paramInt;
      if (this.Glv != null) {
        i = paramInt + f.a.a.a.lB(5, this.Glv.computeSize());
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.signature);
      }
      i = paramInt;
      if (this.GlR != null) {
        i = paramInt + f.a.a.a.lB(7, this.GlR.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(8, this.GlS);
      int j = f.a.a.b.b.a.bz(9, this.GlT);
      AppMethodBeat.o(168948);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168948);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amf localamf = (amf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168948);
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
            localamf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 2: 
          localamf.nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 3: 
          localamf.GlQ = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(168948);
          return 0;
        case 4: 
          localamf.hDQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamf.Glv = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 6: 
          localamf.signature = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamf.GlR = ((alx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 8: 
          localamf.GlS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168948);
          return 0;
        }
        localamf.GlT = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168948);
        return 0;
      }
      AppMethodBeat.o(168948);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amf
 * JD-Core Version:    0.7.0.1
 */