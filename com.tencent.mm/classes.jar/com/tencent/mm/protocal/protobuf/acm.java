package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acm
  extends ckq
{
  public String dlB;
  public String key;
  public String query;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123568);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.key != null) {
        paramVarArgs.d(2, this.key);
      }
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      if (this.query != null) {
        paramVarArgs.d(4, this.query);
      }
      paramVarArgs.aR(5, this.scene);
      if (this.url != null) {
        paramVarArgs.d(6, this.url);
      }
      AppMethodBeat.o(123568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.key != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.key);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlB);
      }
      paramInt = i;
      if (this.query != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.query);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.url);
      }
      AppMethodBeat.o(123568);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123568);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acm localacm = (acm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123568);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacm.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123568);
          return 0;
        case 2: 
          localacm.key = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 3: 
          localacm.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 4: 
          localacm.query = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 5: 
          localacm.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123568);
          return 0;
        }
        localacm.url = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123568);
        return 0;
      }
      AppMethodBeat.o(123568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acm
 * JD-Core Version:    0.7.0.1
 */