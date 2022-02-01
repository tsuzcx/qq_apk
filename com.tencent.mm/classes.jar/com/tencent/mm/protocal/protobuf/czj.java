package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czj
  extends cvc
{
  public int FOJ;
  public int FOK;
  public String FOL;
  public int Fyv;
  public int Ges;
  public eq Hqf;
  public String Hqg;
  public String Hqh;
  public int Hqi;
  public int Hqj;
  public String Md5;
  public String jdf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hqf == null)
      {
        paramVarArgs = new b("Not all required fields were included: Msg");
        AppMethodBeat.o(32426);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hqf != null)
      {
        paramVarArgs.lC(2, this.Hqf.computeSize());
        this.Hqf.writeFields(paramVarArgs);
      }
      if (this.Hqg != null) {
        paramVarArgs.d(3, this.Hqg);
      }
      paramVarArgs.aS(4, this.Ges);
      if (this.Md5 != null) {
        paramVarArgs.d(5, this.Md5);
      }
      paramVarArgs.aS(6, this.Fyv);
      if (this.jdf != null) {
        paramVarArgs.d(7, this.jdf);
      }
      if (this.Hqh != null) {
        paramVarArgs.d(8, this.Hqh);
      }
      paramVarArgs.aS(9, this.Hqi);
      paramVarArgs.aS(10, this.FOJ);
      paramVarArgs.aS(11, this.FOK);
      paramVarArgs.aS(12, this.Hqj);
      if (this.FOL != null) {
        paramVarArgs.d(13, this.FOL);
      }
      AppMethodBeat.o(32426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1109;
      }
    }
    label1109:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hqf != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hqf.computeSize());
      }
      i = paramInt;
      if (this.Hqg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hqg);
      }
      i += f.a.a.b.b.a.bz(4, this.Ges);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Md5);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.Fyv);
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.jdf);
      }
      i = paramInt;
      if (this.Hqh != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hqh);
      }
      i = i + f.a.a.b.b.a.bz(9, this.Hqi) + f.a.a.b.b.a.bz(10, this.FOJ) + f.a.a.b.b.a.bz(11, this.FOK) + f.a.a.b.b.a.bz(12, this.Hqj);
      paramInt = i;
      if (this.FOL != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FOL);
      }
      AppMethodBeat.o(32426);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hqf == null)
        {
          paramVarArgs = new b("Not all required fields were included: Msg");
          AppMethodBeat.o(32426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czj localczj = (czj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32426);
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
            localczj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczj.Hqf = ((eq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 3: 
          localczj.Hqg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 4: 
          localczj.Ges = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32426);
          return 0;
        case 5: 
          localczj.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 6: 
          localczj.Fyv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32426);
          return 0;
        case 7: 
          localczj.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 8: 
          localczj.Hqh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 9: 
          localczj.Hqi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32426);
          return 0;
        case 10: 
          localczj.FOJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32426);
          return 0;
        case 11: 
          localczj.FOK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32426);
          return 0;
        case 12: 
          localczj.Hqj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32426);
          return 0;
        }
        localczj.FOL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32426);
        return 0;
      }
      AppMethodBeat.o(32426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czj
 * JD-Core Version:    0.7.0.1
 */