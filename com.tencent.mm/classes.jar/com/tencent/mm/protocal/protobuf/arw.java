package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arw
  extends cvp
{
  public LinkedList<FinderContact> Gne;
  public LinkedList<FinderContact> GoJ;
  public SKBuiltinBuffer_t Gqg;
  public zv Gqh;
  public int Gqi;
  public int continueFlag;
  public LinkedList<alo> rbl;
  
  public arw()
  {
    AppMethodBeat.i(169062);
    this.Gne = new LinkedList();
    this.GoJ = new LinkedList();
    this.rbl = new LinkedList();
    AppMethodBeat.o(169062);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169063);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Gqh != null)
      {
        paramVarArgs.lC(2, this.Gqh.computeSize());
        this.Gqh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.continueFlag);
      if (this.Gqg != null)
      {
        paramVarArgs.lC(4, this.Gqg.computeSize());
        this.Gqg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.Gne);
      paramVarArgs.e(6, 8, this.GoJ);
      paramVarArgs.e(7, 8, this.rbl);
      paramVarArgs.aS(8, this.Gqi);
      AppMethodBeat.o(169063);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1138;
      }
    }
    label1138:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gqh != null) {
        i = paramInt + f.a.a.a.lB(2, this.Gqh.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.continueFlag);
      paramInt = i;
      if (this.Gqg != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gqg.computeSize());
      }
      i = f.a.a.a.c(5, 8, this.Gne);
      int j = f.a.a.a.c(6, 8, this.GoJ);
      int k = f.a.a.a.c(7, 8, this.rbl);
      int m = f.a.a.b.b.a.bz(8, this.Gqi);
      AppMethodBeat.o(169063);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gne.clear();
        this.GoJ.clear();
        this.rbl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169063);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arw localarw = (arw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169063);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarw.Gqh = ((zv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 3: 
          localarw.continueFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169063);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarw.Gqg = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarw.Gne.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarw.GoJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarw.rbl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        }
        localarw.Gqi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169063);
        return 0;
      }
      AppMethodBeat.o(169063);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arw
 * JD-Core Version:    0.7.0.1
 */