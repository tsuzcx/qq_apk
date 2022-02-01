package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpo
  extends cvc
{
  public int HDB;
  public String HDC;
  public String HDi;
  public String HDj;
  public String HDk;
  public String HDm;
  public String HDw;
  public String desc;
  public int vls;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72607);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HDi != null) {
        paramVarArgs.d(2, this.HDi);
      }
      if (this.HDj != null) {
        paramVarArgs.d(3, this.HDj);
      }
      if (this.HDk != null) {
        paramVarArgs.d(4, this.HDk);
      }
      paramVarArgs.aS(5, this.vls);
      if (this.desc != null) {
        paramVarArgs.d(6, this.desc);
      }
      paramVarArgs.aS(7, this.HDB);
      if (this.HDm != null) {
        paramVarArgs.d(8, this.HDm);
      }
      if (this.HDw != null) {
        paramVarArgs.d(9, this.HDw);
      }
      if (this.HDC != null) {
        paramVarArgs.d(10, this.HDC);
      }
      AppMethodBeat.o(72607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HDi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HDi);
      }
      i = paramInt;
      if (this.HDj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HDj);
      }
      paramInt = i;
      if (this.HDk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HDk);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.vls);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.desc);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.HDB);
      paramInt = i;
      if (this.HDm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HDm);
      }
      i = paramInt;
      if (this.HDw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HDw);
      }
      paramInt = i;
      if (this.HDC != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HDC);
      }
      AppMethodBeat.o(72607);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpo localdpo = (dpo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72607);
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
            localdpo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72607);
          return 0;
        case 2: 
          localdpo.HDi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 3: 
          localdpo.HDj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 4: 
          localdpo.HDk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 5: 
          localdpo.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72607);
          return 0;
        case 6: 
          localdpo.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 7: 
          localdpo.HDB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72607);
          return 0;
        case 8: 
          localdpo.HDm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 9: 
          localdpo.HDw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72607);
          return 0;
        }
        localdpo.HDC = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72607);
        return 0;
      }
      AppMethodBeat.o(72607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpo
 * JD-Core Version:    0.7.0.1
 */