package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doe
  extends dyl
{
  public String SpX;
  public String TVv;
  public int TnB;
  public String request_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200142);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.request_id != null) {
        paramVarArgs.f(2, this.request_id);
      }
      if (this.TVv != null) {
        paramVarArgs.f(3, this.TVv);
      }
      paramVarArgs.aY(4, this.TnB);
      paramVarArgs.aY(100, this.scene);
      if (this.SpX != null) {
        paramVarArgs.f(101, this.SpX);
      }
      AppMethodBeat.o(200142);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label580;
      }
    }
    label580:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.request_id);
      }
      i = paramInt;
      if (this.TVv != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TVv);
      }
      i = i + g.a.a.b.b.a.bM(4, this.TnB) + g.a.a.b.b.a.bM(100, this.scene);
      paramInt = i;
      if (this.SpX != null) {
        paramInt = i + g.a.a.b.b.a.g(101, this.SpX);
      }
      AppMethodBeat.o(200142);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200142);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        doe localdoe = (doe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200142);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdoe.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(200142);
          return 0;
        case 2: 
          localdoe.request_id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(200142);
          return 0;
        case 3: 
          localdoe.TVv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(200142);
          return 0;
        case 4: 
          localdoe.TnB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(200142);
          return 0;
        case 100: 
          localdoe.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(200142);
          return 0;
        }
        localdoe.SpX = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(200142);
        return 0;
      }
      AppMethodBeat.o(200142);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doe
 * JD-Core Version:    0.7.0.1
 */