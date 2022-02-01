package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zc
  extends cld
{
  public LinkedList<bvk> CxK;
  public String Dbg;
  public String Dbh;
  public String hNI;
  
  public zc()
  {
    AppMethodBeat.i(152524);
    this.CxK = new LinkedList();
    AppMethodBeat.o(152524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152525);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.hNI != null) {
        paramVarArgs.d(2, this.hNI);
      }
      paramVarArgs.e(3, 8, this.CxK);
      if (this.Dbg != null) {
        paramVarArgs.d(4, this.Dbg);
      }
      if (this.Dbh != null) {
        paramVarArgs.d(5, this.Dbh);
      }
      AppMethodBeat.o(152525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hNI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hNI);
      }
      i += f.a.a.a.c(3, 8, this.CxK);
      paramInt = i;
      if (this.Dbg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dbg);
      }
      i = paramInt;
      if (this.Dbh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dbh);
      }
      AppMethodBeat.o(152525);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CxK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zc localzc = (zc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152525);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 2: 
          localzc.hNI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152525);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzc.CxK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 4: 
          localzc.Dbg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152525);
          return 0;
        }
        localzc.Dbh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152525);
        return 0;
      }
      AppMethodBeat.o(152525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zc
 * JD-Core Version:    0.7.0.1
 */