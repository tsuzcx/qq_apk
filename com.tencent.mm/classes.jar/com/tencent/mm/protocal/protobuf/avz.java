package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avz
  extends dop
{
  public aov LAI;
  public long LGv;
  public String LGw;
  public long hyH;
  public long object_id;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209519);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LAI != null)
      {
        paramVarArgs.ni(2, this.LAI.computeSize());
        this.LAI.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(3, this.object_id);
      paramVarArgs.bb(4, this.hyH);
      if (this.object_nonce_id != null) {
        paramVarArgs.e(5, this.object_nonce_id);
      }
      paramVarArgs.bb(6, this.LGv);
      if (this.LGw != null) {
        paramVarArgs.e(7, this.LGw);
      }
      AppMethodBeat.o(209519);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LAI != null) {
        i = paramInt + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = i + g.a.a.b.b.a.r(3, this.object_id) + g.a.a.b.b.a.r(4, this.hyH);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.object_nonce_id);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.LGv);
      paramInt = i;
      if (this.LGw != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LGw);
      }
      AppMethodBeat.o(209519);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209519);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avz localavz = (avz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209519);
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
            localavz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209519);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localavz.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209519);
          return 0;
        case 3: 
          localavz.object_id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209519);
          return 0;
        case 4: 
          localavz.hyH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209519);
          return 0;
        case 5: 
          localavz.object_nonce_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209519);
          return 0;
        case 6: 
          localavz.LGv = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209519);
          return 0;
        }
        localavz.LGw = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209519);
        return 0;
      }
      AppMethodBeat.o(209519);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avz
 * JD-Core Version:    0.7.0.1
 */