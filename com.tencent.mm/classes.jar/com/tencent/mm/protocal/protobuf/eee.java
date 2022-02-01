package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eee
  extends dop
{
  public LinkedList<dqi> BlackList;
  public int BlackListCount;
  public LinkedList<dqi> GroupUser;
  public int GroupUserCount;
  public SKBuiltinBuffer_t KLP;
  public SKBuiltinBuffer_t Nem;
  public int Neq;
  public String izX;
  
  public eee()
  {
    AppMethodBeat.i(118468);
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    AppMethodBeat.o(118468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118469);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nem == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118469);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Nem != null)
      {
        paramVarArgs.ni(2, this.Nem.computeSize());
        this.Nem.writeFields(paramVarArgs);
      }
      if (this.izX != null) {
        paramVarArgs.e(3, this.izX);
      }
      if (this.KLP != null)
      {
        paramVarArgs.ni(4, this.KLP.computeSize());
        this.KLP.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.Neq);
      paramVarArgs.aM(6, this.BlackListCount);
      paramVarArgs.e(7, 8, this.BlackList);
      paramVarArgs.aM(8, this.GroupUserCount);
      paramVarArgs.e(9, 8, this.GroupUser);
      AppMethodBeat.o(118469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1154;
      }
    }
    label1154:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nem != null) {
        paramInt = i + g.a.a.a.nh(2, this.Nem.computeSize());
      }
      i = paramInt;
      if (this.izX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.izX);
      }
      paramInt = i;
      if (this.KLP != null) {
        paramInt = i + g.a.a.a.nh(4, this.KLP.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.Neq);
      int j = g.a.a.b.b.a.bu(6, this.BlackListCount);
      int k = g.a.a.a.c(7, 8, this.BlackList);
      int m = g.a.a.b.b.a.bu(8, this.GroupUserCount);
      int n = g.a.a.a.c(9, 8, this.GroupUser);
      AppMethodBeat.o(118469);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.BlackList.clear();
        this.GroupUser.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Nem == null)
        {
          paramVarArgs = new b("Not all required fields were included: ObjDesc");
          AppMethodBeat.o(118469);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eee localeee = (eee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118469);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeee.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeee.Nem = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 3: 
          localeee.izX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118469);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeee.KLP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 5: 
          localeee.Neq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118469);
          return 0;
        case 6: 
          localeee.BlackListCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118469);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeee.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 8: 
          localeee.GroupUserCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118469);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeee.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118469);
        return 0;
      }
      AppMethodBeat.o(118469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eee
 * JD-Core Version:    0.7.0.1
 */