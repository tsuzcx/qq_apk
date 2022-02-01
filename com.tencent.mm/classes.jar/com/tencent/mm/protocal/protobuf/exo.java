package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exo
  extends dyl
{
  public String AttachedText;
  public String AttachedTextColor;
  public int CPw;
  public String LensId;
  public String MD5;
  public boolean UxO;
  public LinkedList<String> UxP;
  public String UxQ;
  public boolean UxT;
  
  public exo()
  {
    AppMethodBeat.i(104842);
    this.UxP = new LinkedList();
    AppMethodBeat.o(104842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104843);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MD5 != null) {
        paramVarArgs.f(2, this.MD5);
      }
      paramVarArgs.co(3, this.UxT);
      paramVarArgs.co(4, this.UxO);
      paramVarArgs.e(5, 1, this.UxP);
      if (this.AttachedText != null) {
        paramVarArgs.f(6, this.AttachedText);
      }
      if (this.UxQ != null) {
        paramVarArgs.f(7, this.UxQ);
      }
      if (this.LensId != null) {
        paramVarArgs.f(8, this.LensId);
      }
      if (this.AttachedTextColor != null) {
        paramVarArgs.f(9, this.AttachedTextColor);
      }
      paramVarArgs.aY(10, this.CPw);
      AppMethodBeat.o(104843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.MD5);
      }
      i = i + (g.a.a.b.b.a.gL(3) + 1) + (g.a.a.b.b.a.gL(4) + 1) + g.a.a.a.c(5, 1, this.UxP);
      paramInt = i;
      if (this.AttachedText != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.AttachedText);
      }
      i = paramInt;
      if (this.UxQ != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.UxQ);
      }
      paramInt = i;
      if (this.LensId != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.LensId);
      }
      i = paramInt;
      if (this.AttachedTextColor != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.AttachedTextColor);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.CPw);
      AppMethodBeat.o(104843);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UxP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        exo localexo = (exo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104843);
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
            localexo.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(104843);
          return 0;
        case 2: 
          localexo.MD5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 3: 
          localexo.UxT = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(104843);
          return 0;
        case 4: 
          localexo.UxO = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(104843);
          return 0;
        case 5: 
          localexo.UxP.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(104843);
          return 0;
        case 6: 
          localexo.AttachedText = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 7: 
          localexo.UxQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 8: 
          localexo.LensId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 9: 
          localexo.AttachedTextColor = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104843);
          return 0;
        }
        localexo.CPw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(104843);
        return 0;
      }
      AppMethodBeat.o(104843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exo
 * JD-Core Version:    0.7.0.1
 */