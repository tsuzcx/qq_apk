package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bik
  extends dyl
{
  public b SSK;
  public b SSL;
  public b SSM;
  public int limit;
  public int scene;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201292);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(2, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.scene);
      if (this.SSK != null) {
        paramVarArgs.c(4, this.SSK);
      }
      if (this.SSL != null) {
        paramVarArgs.c(5, this.SSL);
      }
      if (this.SSM != null) {
        paramVarArgs.c(6, this.SSM);
      }
      paramVarArgs.aY(7, this.limit);
      AppMethodBeat.o(201292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yjp != null) {
        i = paramInt + g.a.a.a.oD(2, this.yjp.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.scene);
      paramInt = i;
      if (this.SSK != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.SSK);
      }
      i = paramInt;
      if (this.SSL != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.SSL);
      }
      paramInt = i;
      if (this.SSM != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.SSM);
      }
      i = g.a.a.b.b.a.bM(7, this.limit);
      AppMethodBeat.o(201292);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201292);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bik localbik = (bik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201292);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbik.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201292);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localbik.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(201292);
          return 0;
        case 3: 
          localbik.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(201292);
          return 0;
        case 4: 
          localbik.SSK = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(201292);
          return 0;
        case 5: 
          localbik.SSL = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(201292);
          return 0;
        case 6: 
          localbik.SSM = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(201292);
          return 0;
        }
        localbik.limit = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(201292);
        return 0;
      }
      AppMethodBeat.o(201292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bik
 * JD-Core Version:    0.7.0.1
 */