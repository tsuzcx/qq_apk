package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dbm
  extends cvw
{
  public bug Guj;
  public int HKm;
  public int Scene;
  public String hFS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152692);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Guj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(152692);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Guj != null)
      {
        paramVarArgs.lJ(2, this.Guj.computeSize());
        this.Guj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HKm);
      paramVarArgs.aS(4, this.Scene);
      if (this.hFS != null) {
        paramVarArgs.d(5, this.hFS);
      }
      AppMethodBeat.o(152692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.a.lI(2, this.Guj.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.HKm) + f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hFS);
      }
      AppMethodBeat.o(152692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Guj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(152692);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152692);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbm localdbm = (dbm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152692);
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
            localdbm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152692);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bug();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bug)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbm.Guj = ((bug)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152692);
          return 0;
        case 3: 
          localdbm.HKm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152692);
          return 0;
        case 4: 
          localdbm.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152692);
          return 0;
        }
        localdbm.hFS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152692);
        return 0;
      }
      AppMethodBeat.o(152692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbm
 * JD-Core Version:    0.7.0.1
 */