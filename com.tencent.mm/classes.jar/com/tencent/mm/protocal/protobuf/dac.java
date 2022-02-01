package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dac
  extends cvc
{
  public String Fvh;
  public String Hqx;
  public String Hqy;
  public String Name;
  public String ufM;
  public String wpT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ufM != null) {
        paramVarArgs.d(2, this.ufM);
      }
      if (this.Hqx != null) {
        paramVarArgs.d(3, this.Hqx);
      }
      if (this.wpT != null) {
        paramVarArgs.d(5, this.wpT);
      }
      if (this.Name != null) {
        paramVarArgs.d(4, this.Name);
      }
      if (this.Fvh != null) {
        paramVarArgs.d(6, this.Fvh);
      }
      if (this.Hqy != null) {
        paramVarArgs.d(7, this.Hqy);
      }
      AppMethodBeat.o(155459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ufM);
      }
      i = paramInt;
      if (this.Hqx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hqx);
      }
      paramInt = i;
      if (this.wpT != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wpT);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Name);
      }
      paramInt = i;
      if (this.Fvh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fvh);
      }
      i = paramInt;
      if (this.Hqy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hqy);
      }
      AppMethodBeat.o(155459);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(155459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dac localdac = (dac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155459);
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
            localdac.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155459);
          return 0;
        case 2: 
          localdac.ufM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 3: 
          localdac.Hqx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 5: 
          localdac.wpT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 4: 
          localdac.Name = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 6: 
          localdac.Fvh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155459);
          return 0;
        }
        localdac.Hqy = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155459);
        return 0;
      }
      AppMethodBeat.o(155459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dac
 * JD-Core Version:    0.7.0.1
 */