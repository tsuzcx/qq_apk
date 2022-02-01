package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ark
  extends com.tencent.mm.bx.a
{
  public String ZBe;
  public LinkedList<String> ZBf;
  public String appId;
  public String desc;
  public String hQQ;
  public arv hXw;
  public String hzi;
  public String title;
  public int type;
  
  public ark()
  {
    AppMethodBeat.i(127463);
    this.ZBf = new LinkedList();
    AppMethodBeat.o(127463);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127464);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.hQQ != null) {
        paramVarArgs.g(3, this.hQQ);
      }
      if (this.ZBe != null) {
        paramVarArgs.g(4, this.ZBe);
      }
      if (this.appId != null) {
        paramVarArgs.g(5, this.appId);
      }
      if (this.hzi != null) {
        paramVarArgs.g(6, this.hzi);
      }
      paramVarArgs.e(7, 1, this.ZBf);
      paramVarArgs.bS(8, this.type);
      if (this.hXw != null)
      {
        paramVarArgs.qD(9, this.hXw.computeSize());
        this.hXw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label756;
      }
    }
    label756:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.hQQ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hQQ);
      }
      paramInt = i;
      if (this.ZBe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZBe);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.appId);
      }
      paramInt = i;
      if (this.hzi != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hzi);
      }
      i = paramInt + i.a.a.a.c(7, 1, this.ZBf) + i.a.a.b.b.a.cJ(8, this.type);
      paramInt = i;
      if (this.hXw != null) {
        paramInt = i + i.a.a.a.qC(9, this.hXw.computeSize());
      }
      AppMethodBeat.o(127464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZBf.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ark localark = (ark)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127464);
          return -1;
        case 1: 
          localark.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 2: 
          localark.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 3: 
          localark.hQQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 4: 
          localark.ZBe = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 5: 
          localark.appId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 6: 
          localark.hzi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 7: 
          localark.ZBf.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(127464);
          return 0;
        case 8: 
          localark.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127464);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          arv localarv = new arv();
          if ((localObject != null) && (localObject.length > 0)) {
            localarv.parseFrom((byte[])localObject);
          }
          localark.hXw = localarv;
          paramInt += 1;
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      AppMethodBeat.o(127464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ark
 * JD-Core Version:    0.7.0.1
 */