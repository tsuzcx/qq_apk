package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class biq
  extends dyl
{
  public b SQZ;
  public b SSL;
  public b SSM;
  public String fIY;
  public int offset;
  public String query;
  public int scene;
  public b xHE;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169048);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.query != null) {
        paramVarArgs.f(2, this.query);
      }
      paramVarArgs.aY(3, this.offset);
      if (this.xHE != null) {
        paramVarArgs.c(4, this.xHE);
      }
      paramVarArgs.aY(5, this.scene);
      if (this.fIY != null) {
        paramVarArgs.f(6, this.fIY);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(7, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.SSL != null) {
        paramVarArgs.c(8, this.SSL);
      }
      if (this.SQZ != null) {
        paramVarArgs.c(9, this.SQZ);
      }
      if (this.SSM != null) {
        paramVarArgs.c(10, this.SSM);
      }
      AppMethodBeat.o(169048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.query);
      }
      i += g.a.a.b.b.a.bM(3, this.offset);
      paramInt = i;
      if (this.xHE != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.xHE);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.scene);
      paramInt = i;
      if (this.fIY != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fIY);
      }
      i = paramInt;
      if (this.yjp != null) {
        i = paramInt + g.a.a.a.oD(7, this.yjp.computeSize());
      }
      paramInt = i;
      if (this.SSL != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.SSL);
      }
      i = paramInt;
      if (this.SQZ != null) {
        i = paramInt + g.a.a.b.b.a.b(9, this.SQZ);
      }
      paramInt = i;
      if (this.SSM != null) {
        paramInt = i + g.a.a.b.b.a.b(10, this.SSM);
      }
      AppMethodBeat.o(169048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        biq localbiq = (biq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169048);
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
            localbiq.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169048);
          return 0;
        case 2: 
          localbiq.query = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169048);
          return 0;
        case 3: 
          localbiq.offset = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169048);
          return 0;
        case 4: 
          localbiq.xHE = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169048);
          return 0;
        case 5: 
          localbiq.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169048);
          return 0;
        case 6: 
          localbiq.fIY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169048);
          return 0;
        case 7: 
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
            localbiq.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169048);
          return 0;
        case 8: 
          localbiq.SSL = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169048);
          return 0;
        case 9: 
          localbiq.SQZ = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169048);
          return 0;
        }
        localbiq.SSM = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(169048);
        return 0;
      }
      AppMethodBeat.o(169048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biq
 * JD-Core Version:    0.7.0.1
 */