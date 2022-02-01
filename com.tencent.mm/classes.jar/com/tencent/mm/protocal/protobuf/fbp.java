package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbp
  extends com.tencent.mm.cd.a
{
  public String UBI;
  public String UBN;
  public LinkedList<dhw> UiG;
  public int action;
  public String axB;
  public int type;
  public String viewId;
  
  public fbp()
  {
    AppMethodBeat.i(252380);
    this.UiG = new LinkedList();
    AppMethodBeat.o(252380);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(252381);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.viewId != null) {
        paramVarArgs.f(1, this.viewId);
      }
      paramVarArgs.aY(2, this.type);
      if (this.axB != null) {
        paramVarArgs.f(3, this.axB);
      }
      paramVarArgs.aY(4, this.action);
      paramVarArgs.e(5, 8, this.UiG);
      if (this.UBI != null) {
        paramVarArgs.f(6, this.UBI);
      }
      if (this.UBN != null) {
        paramVarArgs.f(7, this.UBN);
      }
      AppMethodBeat.o(252381);
      return 0;
    }
    if (paramInt == 1) {
      if (this.viewId == null) {
        break label604;
      }
    }
    label604:
    for (paramInt = g.a.a.b.b.a.g(1, this.viewId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.axB != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.axB);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.action) + g.a.a.a.c(5, 8, this.UiG);
      paramInt = i;
      if (this.UBI != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UBI);
      }
      i = paramInt;
      if (this.UBN != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.UBN);
      }
      AppMethodBeat.o(252381);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UiG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(252381);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fbp localfbp = (fbp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(252381);
          return -1;
        case 1: 
          localfbp.viewId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(252381);
          return 0;
        case 2: 
          localfbp.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252381);
          return 0;
        case 3: 
          localfbp.axB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(252381);
          return 0;
        case 4: 
          localfbp.action = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252381);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dhw localdhw = new dhw();
            if ((localObject != null) && (localObject.length > 0)) {
              localdhw.parseFrom((byte[])localObject);
            }
            localfbp.UiG.add(localdhw);
            paramInt += 1;
          }
          AppMethodBeat.o(252381);
          return 0;
        case 6: 
          localfbp.UBI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(252381);
          return 0;
        }
        localfbp.UBN = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(252381);
        return 0;
      }
      AppMethodBeat.o(252381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbp
 * JD-Core Version:    0.7.0.1
 */